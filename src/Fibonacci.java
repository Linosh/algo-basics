import java.util.Arrays;

/**
 * Created by dmitriiiermiichuk on 6/5/16.
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n = 30;
        int[] fiboList = new int[n + 1];
        new Fibonacci().fibonacci(n, fiboList);
        System.out.println(Arrays.toString(fiboList));
    }

    public int fibonacci(int n, int[] acc) {
        if (n <= 1) return n;

        if (acc[n] != 0) return acc[n];

        acc[n] = fibonacci(n - 1, acc) + fibonacci(n - 2, acc);

        return acc[n];
    }
}
