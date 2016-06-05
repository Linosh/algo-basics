/**
 * Created by dmitriiiermiichuk on 6/2/16.
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));
    }

    /**
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     */
    public static boolean isMatch(String s, String p) {
        int matched = 0;
        String pFrame = "";
        String sFrame = "";
        for (int i=0; i< p.length() - 1; i++) {
//            frame += p.substring(i, i+1);


        }


        return matched == s.length();
    }
}
