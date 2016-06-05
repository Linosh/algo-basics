import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dmitriiiermiichuk on 6/5/16.
 */
public class AddOneToNumber {

    public static void main(String[] args) {
        System.out.println(new AddOneToNumber().plusOne(new ArrayList<>(Arrays.asList(6, 4, 7, 7, 8, 9))));
    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        // make zero check
        int startPos = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > 0) {
                startPos = i;
                break;
            }
        }


        Integer[] res = new Integer[a.size() - startPos];

        int stopPos = a.size() - 1;
        int prev = 1;
        for (int i = a.size() - 1; i >= startPos; i--) {
            int v = a.get(i) + prev;
            if (v <= 9) {
                stopPos = i;
                res[i - startPos] = v;
                prev = 0;
                break;
            } else {
                prev = v - 9;
                res[i - startPos] = 0;
            }
        }

        if (prev > 0) {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(prev);
            l.addAll(Arrays.asList(res));
            return l;
        }

        for (int i = 0; i < stopPos - startPos; i++) {
            res[i] = a.get(i + startPos);
        }

        return new ArrayList<>(Arrays.asList(res));
    }
}
