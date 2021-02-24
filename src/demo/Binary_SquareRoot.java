package demo;

/**
 *
 */
public class Binary_SquareRoot {
    public static void main(String[] args) {
        System.out.println(binary_SquareRoot(100000000));
    }

    public static int binary_SquareRoot(int n) {

        long left = 0;
        long right = n / 2 + 1;


        while (left <= right) {
            long mid  = (left + right) / 2;
            long result = mid * mid;
            if (result == n) {
                return (int) mid;
            } else if (result > n) {
                right = --mid;

            } else {
                left = ++mid;
            }
        }


        return (int)right;
    }
}
