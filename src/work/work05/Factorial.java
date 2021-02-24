package work.work05;

import java.util.Scanner;

/**
 *N的阶乘
 */
public class Factorial {
    public static void Factorial(int n){
        int num[] = new int[100000000];
        int i, j;
        if (n == 1 || n == 0) {
            System.out.println(1);
        } else {
            int p=1;//p存放当前结果的位数，
            int h=0;//h为进位；
            num[1] = 1;
            for (i = 2; i <= n; i++) {
                // 使得a[]的每位与i相乘
                for (j = 1; j <= p; j++) {
                    num[j] = num[j] * i + h;
                    h = num[j] / 10;
                    num[j] = num[j] % 10;
                }
                while (h > 0) {// 表示向新的位置进位
                    num[j] = h % 10;
                    h = h / 10;
                    j++;
                }
                p = j - 1;
            }
            System.out.print("n!=");
            for (i = p; i >= 1; i--) {
                System.out.print(num[i]);
            }
        }

    }
    public static void check(Scanner scanner){
        Scanner sc=new Scanner(System.in);
        if(scanner.hasNextInt()){
            Factorial(scanner.nextInt());
        }else {
            System.out.print("输入错误，重新输入：n=");
            check(sc);
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("n=");
        check(scanner);



    }
}
