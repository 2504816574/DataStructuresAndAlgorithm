package finalExam;

import java.util.Scanner;

/**
 *原理：https://blog.csdn.net/coolyuan/article/details/105093123
 *代码:https://blog.csdn.net/sunone_/article/details/53133557?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase
 */
public class EShiSuanFa {
    public static int eShiSuanFa(int num1, int num2) {
        int sum = 0, a = 0;
        if (num1 == 0 || num2 == 0)
            return 0;
        if (num1 == 1)
            return num2;
        while (num1 != 1) {
            if (num1 % 2 == 0) {
                num1 = num1 / 2;
                num2 *= 2;
            } else {
                num1 = num1 / 2;
                a += num2;
                num2 *= 2;
            }
        }
        sum = a + num2;
        return sum;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入A、B:");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        System.out.println("A*B=" + eShiSuanFa(num1 <= num2 ? num1 : num2, num1 >= num2 ? num1 : num2));


    }
}
