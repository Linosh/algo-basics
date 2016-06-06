/**
 * Created by dmitriiiermiichuk on 6/2/16.
 *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

 You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

 Credits:
 Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
public class FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(100));
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    public static boolean isBadVersion(int version) {
        return version >= 5;
    }
}
