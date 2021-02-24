package other.gcd;


import other.gcd.common.Put;

/**
 *最大公约数-循环测试法
 *
 * Step1：将min{m,n}的值赋给t。
 * Step2：判断t是否为0，如果是0，返回 max{m,n}；否则，进入第三步。
 * Step3：m除以t，如果余数为0，则进入第四步；否则进入第五步。
 * Step4：n除以t，如果余数为0，则返回t值作为结果；否则进入第五步。
 * Step5：把t的值减1，返回第三步
 */
public class CirculationTestAlgorithm {
    public static int circulationTestAlgorithm(int num1,int num2){
        int temp=Math.min(num1,num2);
        int prime_gcd = 1;
        if(temp==0){
            prime_gcd=Math.max(num1, num2);
        }else {
            while (temp > 0) {
                if (num1%temp==0&&num2%temp==0){
                    prime_gcd=temp;
                    break;
                }else {
                    temp--;
                }
            }
        }

        return prime_gcd;
    }

    public static void main(String[] args) {
        int[] num= Put.input2();
        System.out.println(num[2]+"和"+num[3]+"的最大公约数为（循环测试法）："+circulationTestAlgorithm(num[0],num[1]));
    }
}
