package other.gcd;

import other.gcd.common.Put;

import java.util.ArrayList;


/**
 * 最大公约数-质因数分解法
 * 把每个数分别分解质因数 ，再把各数中的全部公有质因数 提取出来连乘，所得的积就是这 几个数的最大公约数
 *
 * CSDN:https://blog.csdn.net/qq_31828515/article/details/51812154?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2
 *
 */
public class PrimeFactorization {
    public static int primeFactorization(int num1, int num2) {
        int prime_gcd = 1;
        if (num2!=0) {
            if (num1 % num2 == 0) {
                prime_gcd = num2;
            } else if (num2 % num1 == 0) {
                prime_gcd = num1;
            } else {
                int pn1 = num1, pn2 = num2;
                ArrayList<Integer> num1List = new ArrayList<>();
                ArrayList<Integer> num2List = new ArrayList<>();

                //求出质因数
                for (int i = 2; i < pn1 / 2; ) {//注意此处用的是pn1，而不是num1，num1的值在以下的运行过程会不断减小
                    if (num1 % i == 0) {//判断能否整除
                        num1 /= i;//如果可以整除，则整除后重新复制给num1
                        num1List.add(i);//将质因数放入num1List
                    } else {
                        i++;//假设余数不等于0。除数i加1，继续求余数
                    }
                }

                for (int i = 2; i < pn2 / 2; ) {
                    if (num2 % i == 0) {
                        num2 /= i;
                        num2List.add(i);
                    } else {
                        i++;
                    }
                }
                int num1ListSize = num1List.size();//两个ArrayList大小
                int num2ListSize = num2List.size();
                if (num1ListSize < num2ListSize) {
                    for (int i = 0; i < num1List.size(); i++) {
                        if (num2List.contains(num1List.get(i))) {
                            prime_gcd *= num1List.get(i);
                            num2List.remove(num2List.indexOf(num1List.get(i)));
                            num1List.remove(i);
                            if (num1List.size() == 0 || num2List.size() == 0) {
                                break;
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < num2List.size(); i++) {
                        if (num1List.contains(num2List.get(i))) {
                            prime_gcd *= num2List.get(i);
                            num1List.remove(num1List.indexOf(num2List.get(i)));
                            num2List.remove(i);
                            if (num1List.size() == 0 || num2List.size() == 0) {
                                break;
                            }
                        }
                    }
                }
            }
        }else {
            prime_gcd=num1;
        }
        return prime_gcd;
    }

    public static void main(String[] args) {
        int[] num= Put.input2();
        System.out.println(num[2]+"和"+num[3]+"的最大公约数为（质因数分解法）："+primeFactorization(num[0],num[1]));
    }
}
