package work.work11;

import java.util.Arrays;

/**
 *
 */
public class CountingSort {
    public static int[] countingSort(int[] A,int[] B,int k) {
        int[] c = new int[k + 1];//存放0~k
        for (int i = 0; i < A.length; i++)
            c[A[i]] += 1;
        for (int i = 1; i <= k; i++)
            c[i] += c[i - 1];
        for (int i = A.length - 1; i >= 0; i--) {
            c[A[i]]--;
            B[c[A[i]]] = A[i];
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A={2,5,3,0,2,3,0,3};
        System.out.println(Arrays.toString(A));
        int[] B=new int[A.length];
        System.out.println(Arrays.toString(countingSort(A,B,5)));


    }

}
