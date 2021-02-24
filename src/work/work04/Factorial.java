package work.work04;

import java.math.BigInteger;

/**
 *100 的阶乘
 */
public class Factorial {
    public static void main(String[] args) {
        BigInteger a=new BigInteger("1");
        for (int i=1;i<=100;i++){
            BigInteger num=new BigInteger(String.valueOf(i));
            a=a.multiply(num);
        }
        System.out.println(a);
    }
}
