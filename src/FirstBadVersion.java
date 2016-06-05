/**
 * Created by dmitriiiermiichuk on 6/2/16.
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
