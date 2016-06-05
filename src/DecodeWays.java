import java.util.Arrays;

/**
 * Created by dmitriiiermiichuk on 6/2/16.
 */
public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("100"));
        System.out.println(new DecodeWays().numDecodings("00"));
        System.out.println(new DecodeWays().numDecodings("001"));
        System.out.println(new DecodeWays().numDecodings("10"));
        System.out.println(new DecodeWays().numDecodings("1010"));
        System.out.println(new DecodeWays().numDecodings("012"));
        System.out.println(new DecodeWays().numDecodings("101"));
        System.out.println(new DecodeWays().numDecodings("112110"));
    }

    public int numDecodings(String s) {

        if (s.length() == 0) return 0;
        int pre = 27, digit, answer = 0, first = 1, second = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            digit = s.charAt(i) - '0';
            if (digit == 0) answer = 0;
            else answer = first + (digit * 10 + pre < 27 ? second : 0);
            second = first;
            first = answer;
            pre = digit;
        }
        return answer;
    }
}
