package other.gcd;


import other.gcd.common.Put;

/**
 *求最大公约数-欧几里得法（辗转相除法）
 *
 * 用较大数除以较小数，再用出现的余数（第一余 数）去除除数，
 * 再用出现的余数（第二余数）去 除第一余数，如此反复，直到最后余数是0为止 。
 * 那么最后的除数就是这两个数的最大公约数
 *
 * CSDN:https://blog.csdn.net/qq_25847123/article/details/95753295?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-1&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-1
 * CSDN:https://blog.csdn.net/qq_31828515/article/details/51812154?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2
 * 视频：https://www.bilibili.com/video/BV15W411A7Wy?from=search&seid=8915332190505187314
 */
public class EuclideanAlgorithm {
    //递归
    public static int euclideanAlgorithm1(int num1,int num2){
        return num2==0?num1:euclideanAlgorithm1(num2,num1%num2);
    }
    //循环
    public static int euclideanAlgorithm2(int num1, int num2) {
        int prime_gcd;
        if(num2!=0) {
            int temp = num1 % num2;
            while (temp != 0) {
                num1 = num2;
                num2 = temp;
                temp = num1 % num2;
            }
            prime_gcd= num2;
        }else {
            prime_gcd= num1;
        }
        return prime_gcd;


    }

    public static void main(String[] args) {
        int[] num= Put.input2();
        System.out.println(num[2]+"和"+num[3]+"的最大公约数为（欧几里得法-递归）："+euclideanAlgorithm1(num[0],num[1]));
        System.out.println(num[2]+"和"+num[3]+"的最大公约数为（欧几里得法-循环）："+euclideanAlgorithm2(num[0],num[1]));
    }
}
