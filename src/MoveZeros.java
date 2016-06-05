import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 0, 3, 12};
        moveZeros2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeros2(int[] nums) {
        int i = -1, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                if (++i != j) {
                    swap(i, j, nums);
                }
            }
            j++;
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
