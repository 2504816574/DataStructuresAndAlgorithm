package work.work08;

import java.util.Scanner;

/**
 *
 */
public class Power {
    public static int power(int a, int n) {
        if (n == 0) {// 如果n=0，则输出结果为1，
            return 1;
        } else if (n == 1) {// 如果n=1，则输出a
            return a;
        } else if (n % 2 == 0) {// 如果n为偶数，a^n可以分治为(a^2/n)*(a^2/n)，并且递归的调用自己
            return power(a, n / 2) * power(a, n / 2);
        } else if (n % 2 != 0) {// n为奇数的时候，a^n可以分治为(a^2/n)*(a^2/n)*a,并且递归的调用自己
            return power(a, n / 2) * power(a, n / 2) * a;
        }
        return a;

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入n,n:");
        int a=scanner.nextInt();
        int n=scanner.nextInt();
        System.out.println(a+"^"+n+"="+power(a,n));
    }
}
