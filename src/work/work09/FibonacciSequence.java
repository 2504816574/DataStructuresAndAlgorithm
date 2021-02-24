package work.work09;

/**
 *
 */
public class FibonacciSequence {
    public static int Fib(int n) {//用递归实现斐波那契数列
        int result;
        if (n == 1 || n == 2) {
            return 1;
        }
        result = Fib(n - 1) + Fib(n - 2);
        return result;
    }

    public static void main(String[] args) {
        for (int i=0;i<=20;i++){
            System.out.println(Fib(i));
        }

    }

}
