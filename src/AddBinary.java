import java.math.BigDecimal;

/**
 * Created by dmitriiiermiichuk on 6/2/16.
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        if (a == null || a.equals("") || b == null || b.equals("")) return "";

        int al = a.length();
        int bl = b.length();

        int maxl = Math.max(al, bl);

        String res = "";
        int prev = 0;
        for (int i=0; i < maxl; i++) {
            int ai = a.length() > i ? a.charAt(al - i - 1) - '0' : 0;
            int bi = b.length() > i ? b.charAt(bl - i - 1) - '0' : 0;

            int sum = ai + bi + prev;
            if (sum > 1) {
                res = sum % 2 + res;
                prev = 1;
            } else {
                res = sum + res;
                prev = 0;
            }
        }

        return prev > 0 ? (prev + res) : res;
    }
}
