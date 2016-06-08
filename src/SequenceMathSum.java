/**
 * Created by dmitriiiermiichuk on 6/7/16.
 *
 *
 Problem: Given a sequence of nonnegative integers A and an integer T, return whether there is a *continuous sequence* of A that sums up to exactly T

 Example
 [23, 5, 4, 7, 2, 11], 20. Return True because 7 + 2 + 11 = 20
 [1, 3, 5, 23, 2], 8. Return True because 3 + 5 = 8
 [1, 3, 5, 23, 2], 7 Return False because no sequence in this array adds up to 7

 Note: We are looking for an O(N) solution. There is an obvious O(N^2) solution which is a good starting point but is not the final solution we are looking for.

 */
class SequenceMathSum {
    public static void main(String[] args) {

    }


    /**
     Solution #2
     */
    public boolean findSum2(int[] arr, int goalSum) {

        return doFindSum2(arr, 0, arr.length - 1, goalSum, 0);

    }

    public boolean doFindSum2(int[] arr, int lo, int hi, int goalSum, int tmpSum) {

        if (lo > hi) return false;

        int mid = lo + (hi - lo)/2;

        if (hi - lo == 1)
            tmpSum = arr[lo] + arr[hi];

        if (tmpSum == goalSum) {
            return true;
        }


        doFindSum2(arr, lo, mid, goalSum, tmpSum);
        doFindSum2(arr, mid + 1, hi, goalSum, tmpSum);

        return false;
    }


    /**
     Solution #1
     */
    public boolean findSum(int[] arr, int goalSum) {

        if (arr == null || arr.length == 0) {
            return false;
        }

        int tmpSum = 0;
        int resumeInd = 0;
        int i = 0;
        while (i<arr.length) {
            tmpSum += arr[i];

            if (tmpSum > goalSum) {
                int tmpInd = i;
                i = resumeInd + 1;
                resumeInd = tmpInd;
                tmpSum = 0;
            } else {
                i++;
            }

            if (tmpSum == goalSum) {
                return true;
            }

        }

        return false;
    }
}
