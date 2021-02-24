package work.work08;

import java.util.Scanner;

/**
 *
 */
public class IntegerDivision {
    public static int divide(int n, int m) {
        if (n < 1 || m < 1) {
            return 0;
        } else if (n == 1 || m == 1) {
            return 1;
        } else if (n < m) {
            return divide(n, n);
        } else if (n == m) {
            return divide(n, m - 1) + 1;
        } else {
            return divide(n, m - 1) + divide(n - m, m);
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入n,n:");
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        System.out.println("一共有"+divide(n,m)+"划分方法");
    }

}
