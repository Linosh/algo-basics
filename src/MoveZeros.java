import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 Credits:
 Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */

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
