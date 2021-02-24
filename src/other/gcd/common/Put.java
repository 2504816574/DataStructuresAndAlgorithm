package other.gcd.common;

import java.util.Scanner;

/**
 *控制台输入两个整数，大数在前，小数在后
 */
public class Put {
    public static int[] input2(){
        System.out.println("输入两个整数： ");
        Scanner scanner=new Scanner(System.in);
        int[] num=new int[4];
        int n1=scanner.nextInt();
        int n2=scanner.nextInt();
        num[0]=Math.max(n1,n2);
        num[1]=Math.min(n1,n2);
        num[2]=n1;
        num[3]=n2;
        return num;
    }

}
