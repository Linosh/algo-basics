import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmitriiiermiichuk on 6/2/16.
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 2, 4}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int k = 0;
        while (k < nums.length) {
            for (int i = k + 1; i < nums.length; i++) {
                if (nums[k] + nums[i] == target) {
                    return new int[]{k, i};
                }
            }

            k++;
        }

        return new int[]{};
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
