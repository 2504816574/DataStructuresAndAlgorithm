package finalExam;

import java.util.Arrays;
import java.util.Random;

/**
 *
 */
public class TheSecondLargestNumber {
    static int[] arr=new int[10];
    static int n=arr.length;
    static int max;
    public static int theSecondLargestNumber(int n){
        int min;
        if(n==2){
            if(arr[0]>=arr[1]){
                return arr[1];
            }else {
                return arr[0];
            }
        }else {
            min=theSecondLargestNumber(n-1);
            if(arr[n-1]>max){
                min=max;
                max=arr[n-1];
            }
            if (arr[n-1]<max&&arr[n-1]>min){
                min=arr[n-1];
            }
            return min;
        }
    }

    public static void main(String[] args) {
        Random random=new Random();
        for (int i=0;i<n;i++){
            arr[i]=random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("第二大数字为:"+theSecondLargestNumber(n));
    }
}
