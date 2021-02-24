package other.data_structure.demo;

import java.util.Scanner;

/**
 * 1+2+3+........+n
 */
public class AddOneToN {
    public static int addOneToN01(int n){//遍历加
        int total=0;
        for (int i=0;i<=n;i++){
            total+=i;
        }
        return total;

    }
    public static int addOneToN02(int n){//首尾相加*（数量/2）
        int total=0;
        if(n%2==0){//如果n是偶数，直接/首尾相加*（数量/2）
            total=(1+n)*(n/2);
        }else{//如果n是奇数,求1+2+..+n-1，再加上n
            total=(1+n-1)*((n-1)/2)+n;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("输入正整数n：");
        int n=scanner.nextInt();
        System.out.println("1+2+3+........+n="+addOneToN01(n));
        System.out.println("1+2+3+........+n="+addOneToN02(n));

    }
}
