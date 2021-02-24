package work.work04;

import java.util.Scanner;

/**
 *汉罗塔问题
 */
public class Hanoi {
    public static void move(int n,String A,String B,String C ){
        if (n==1){
            System.out.println(A+"-->"+C);
        }else {
            move(n-1,A,C,B);
            System.out.println(A+"-->"+C);
            move(n-1,B,A,C);
        }
    }
    public static void check(Scanner scanner){
        Scanner sc=new Scanner(System.in);
        if(scanner.hasNextInt()){
           int n=scanner.nextInt();
           move(n,"A","B","C");

        }else {
            System.out.println("输入应为纯数字，请重新输入：");
           check(sc);
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入盘子个数：");
        check(scanner);


    }
}
