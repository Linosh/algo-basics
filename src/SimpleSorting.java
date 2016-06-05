import java.util.Arrays;

/**
 * Created by dmitriiiermiichuk on 6/4/16.
 */
public class SimpleSorting {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1};
        new SimpleSorting().insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j-1] > arr[j]) swap(j-1, j, arr);
            }
        }
    }

    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j-1] > arr[j]; j--) {
                swap(j-1, j, arr);
            }
        }
    }

    public void selectionSort(int[] arr) {
        int p = 0;

        while (p < arr.length) {
            int s = p;
            for (int i=p+1; i<arr.length;i++) {
                if (arr[s] > arr[i]) {
                    s = i;
                }
            }

            swap(p, s, arr);
            p++;
        }
    }

    public void swap(int i, int j, int[] arr) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
