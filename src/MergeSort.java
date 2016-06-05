import java.util.Arrays;

/**
 * Created by dmitriiiermiichuk on 6/4/16.
 */
public class MergeSort {
    static int[] aux;
    public static void main(String[] args) {
        int[] arr = new int[] {5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        aux = new int[arr.length];
        doSort(arr, 0, arr.length - 1);
    }

    private static void doSort(int[] arr, int lo, int hi) {
        if (hi <= lo) return;

        int mid = lo + (hi - lo) / 2;

        doSort(arr, lo, mid);
        doSort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        int i=lo, j=mid+1;

        System.arraycopy(arr, lo, aux, lo, hi + 1 - lo);

        for (int k=lo; k<=hi; k++) {
            if      (i > mid)         arr[k] = aux[j++];
            else if (j > hi)          arr[k] = aux[i++];
            else if (aux[j] < aux[i]) arr[k] = aux[j++];
            else                      arr[k] = aux[i++];
        }
    }
}
