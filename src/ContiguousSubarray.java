import java.util.Arrays;
import java.util.List;

/**
 * Created by dmitriiiermiichuk on 6/5/16.
 */
public class ContiguousSubarray {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4);
        System.out.println(new ContiguousSubarray().maxSubArray3(arr, arr.size()));
    }

    public int maxSubArray(final List<Integer> arr, int n) {

        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            int tmpSum = 0;
            for (int j = 1; j < arr.size(); j++) {
                if (i + j > arr.size()) break;
                tmpSum += arr.get(i + j - 1);
                sum = Math.max(tmpSum, sum);
            }
        }

        return sum;
    }


    public int maxSubArray2(final List<Integer> arr, int n) {

        if (n == 1) {
            return arr.get(n);
        }

        int mid = n/2;

        int leftMss = maxSubArray2(arr, mid);
        int rightMss = maxSubArray2(arr, n-mid);

        int leftSum = Integer.MIN_VALUE, righSum = Integer.MIN_VALUE, tmpSum = 0;

        for (int i=mid-1; i >= 0; i--) {
            tmpSum += arr.get(i);
            leftSum = Math.max(tmpSum, leftSum);
        }

        tmpSum = 0;
        for (int i=mid; i < n; i++) {
            tmpSum += arr.get(i);
            righSum = Math.max(tmpSum, righSum);
        }

        int ans = Math.max(rightMss, leftMss);
        return Math.max(ans, leftSum + righSum);
    }

    public int maxSubArray3(final List<Integer> arr, int n) {

        // if all are negative
        int sum = Integer.MIN_VALUE;
        boolean isNeg = true;
        for (Integer anArr1 : arr) {
            int val = anArr1;
            if (val > 0) isNeg = false;
            sum = Math.max(sum, val);
        }

        if (isNeg) return sum;

        // if at least one is positive
        sum = 0;
        int ans = 0;
        for (Integer e : arr) {

            if (sum + e > 0)
                sum += e;
            else
                sum = 0;
            ans = Math.max(ans, sum);
        }

        return ans;

    }
}
