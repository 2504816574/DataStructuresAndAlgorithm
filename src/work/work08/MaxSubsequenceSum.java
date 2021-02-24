package work.work08;

import java.util.Scanner;

/**
 *
 */
public class MaxSubsequenceSum {
    public static int maxSubsequenceSum(int[] array,int n){
        int tempSum = 0;
        int maxSum = 0;
        for (int j = 0;j < n;j++)   // 子问题后边界
        {
            tempSum = (tempSum + array[j]) > array[j] ? (tempSum + array[j]) : array[j];
            if (tempSum > maxSum)   // 更新最大和
                maxSum = tempSum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] array={-8, 11, -4, 13, -9, -10};
        System.out.println("最大字段和为："+maxSubsequenceSum(array,array.length));

    }


}
