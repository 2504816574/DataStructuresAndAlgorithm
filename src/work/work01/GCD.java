package work.work01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 求两个数的最大公约数
 */
public class GCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("求两个数的最大公约数");
        System.out.println("输入第一个正整数num1:");
        int num1 = scanner.nextInt();
        System.out.println("输入第二个正整数num2:");
        int num2 = scanner.nextInt();


        //让较大数为num1,较小数为num2
        int num3;
        if (num2 > num1) {
            num3 = num1;
            num1 = num2;
            num2 = num3;
        }


        System.out.println(num1 + "和" + num2 + "的最大公约数为（质因数分解法）：" + factorization(num1, num2));
        System.out.println(num1 + "和" + num2 + "的最大公约数为（循环测试法）：" + cycletest(num1, num2));
        System.out.println(num1 + "和" + num2 + "的最大公约数为（欧几里得法）：" + euclidMethod(num1, num2));
    }

    public static int factorization(int num1, int num2) {
        int prime_gcd = 1;
        int temp1, temp2;
        int pn1 = num1, pn2 = num2;
        List<Integer> num1List = new ArrayList();
        List<Integer> num2List = new ArrayList();
        //求出质因数
        for (int i = 2; i < pn1/2;) {
            if (num1%i == 0) {		//求余数，假设能被整除，返回true
                temp1 = num1 / i;		//求商
                num1 = temp1;		//将商赋值给primeNum1。又一次推断余数是否为0
                num1List.add(i);		//将质因数放入num1List
            } else if (num1%i != 0) {
                i = i + 1;		//假设余数不等于0。除数i加1，继续求余数
            }
        }
        for (int i = 2; i < pn2/2;) {
            if (num2%i == 0) {
                temp2 = num2 / i;
                num2 = temp2;
                num2List.add(i);
            } else if (num2%i != 0) {
                i = i + 1;
            }
        }
        int num1ListSize = num1List.size();
        int num2ListSize = num2List.size();
        if (num1ListSize < num2ListSize) {
            for (int i = 0; i < num1List.size();) {
                if (num2List.contains(num1List.get(i))) {
                    prime_gcd *= num1List.get(i);
                    num2List.remove(num2List.indexOf(num1List.get(i)));
                    num1List.remove(i);
                    if (num1List.size() == 0 || num2List.size() == 0)
                        break;
                } else {
                    i = i + 1;
                }
            }
        } else {
            for (int i = 0; i < num2List.size(); ) {
                if (num1List.contains(num2List.get(i))) {
                    prime_gcd *= num2List.get(i);
                    num1List.remove(num1List.indexOf(num2List.get(i)));
                    num2List.remove(i);
                    if (num1List.size() == 0 || num2List.size() == 0)
                        break;
                } else {
                    i = i + 1;
                }
            }
        }
        return prime_gcd;

    }

    public static int cycletest(int num1, int num2) {
        int num3 = num2;
        for (; num3 > 0; num3--) {
            if (num1 % num3 == 0 && num2 % num3 == 0) {
                break;
            }
        }
        return num3;

    }

    public static int euclidMethod(int num1, int num2) {
        int num3;
        if (num2 == 0) {
            num3 = num1;
        } else {
            num3 = euclidMethod(num2, num1 % num2);
        }
        return num3;


    }
}
