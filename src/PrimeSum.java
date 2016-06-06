import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dmitriiiermiichuk on 6/5/16.
 */
public class PrimeSum {
    public static void main(String[] args) {
        System.out.println(new PrimeSum().primesum(16777214));
    }


    /**
     * 4 = 2 2
     * 5 = 2 3
     * 6 = 3 3
     * 7 = 2 5
     * 8 = 3 5
     * 9 =
     */

    public ArrayList<Integer> primesum(int a) {

        if (a < 4) return new ArrayList<>();

        if (a == 4) return new ArrayList<>(Arrays.asList(2, 2));

        // generate all prime numbers
        Integer[] primesFlags = new Integer[a+1];
        primesFlags[0] = 0;
        primesFlags[1] = 0;
        for (int i = 2; i < a; i++) {
            primesFlags[i] = 1;
        }

        for (int i = 2; i < Math.sqrt(a); i++) {
            if (primesFlags[i] == 1) {
                for (int j=2; i*j <= a; j++) {
                    primesFlags[i*j] =  0;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i=0; i < primesFlags.length; i++) {
            if (primesFlags[i] == 1) primes.add(i);
        }

        int l = 0, r = primes.size() - 1;
        while (l <= r) {
            int lp = primes.get(l);
            int rp = primes.get(r);
            int v = lp + rp;
            if (v == a) return new ArrayList<>(Arrays.asList(lp, rp));
            if (v < a) l++;
            else r--;
        }

        return new ArrayList<>();
    }
}
