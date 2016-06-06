/**
 * Created by dmitriiiermiichuk on 6/2/16.
 *
 * Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("aabbff", "a.*"));
    }

    /**
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     */
    public static boolean isMatch(String s, String p) {
        // try matching with asterisk
        if (p == null || p.length() == 0) return (s == null || s.length() == 0);

        return matches(s, 0, p, 0);
    }

    public static boolean matches(String s, int sIndex, String p, int pIndex) {
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }

        if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
            while (true) {
                if (matches(s, sIndex, p, pIndex + 2)) {
                    return true;
                }
                if (sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.')) {
                    sIndex++;
                } else {
                    return matches(s, sIndex, p, pIndex + 2);
                }
            }
        }

        if (sIndex == s.length()) {
            return false;
        }

        if (p.charAt(pIndex) == '.' || p.charAt(pIndex) == s.charAt(sIndex)) {
            return matches(s, sIndex + 1, p, pIndex + 1);
        }

        return false;
    }
}
