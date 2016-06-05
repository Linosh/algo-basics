import java.util.Arrays;

/**
 * Created by dmitriiiermiichuk on 6/5/16.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{6,5,4,5,4,3,5};
        new QuickSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        doSort(arr, 0, arr.length - 1);
    }

    private void doSort(int[] arr, int lo, int hi) {
        if (hi <= lo) return;

        int j = partition(arr, lo, hi);
        doSort(arr, lo, j - 1);
        doSort(arr, j + 1, hi);
    }

    private int partition(int[] arr, int lo, int hi) {
        int i = lo, j = hi + 1;

        int p = arr[lo];
        while (true) {
            while (arr[++i] < p) if(i == hi) break;
            while (arr[--j] > p) if(j == lo) break;

            if (i >= j) break;

            swap(i, j, arr);
        }

        swap(j, lo, arr);
        return j;
    }

    private void swap(int i, int j, int[] arr) {
        if (i == j) return;
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
