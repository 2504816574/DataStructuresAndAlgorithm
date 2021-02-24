package finalExam;

import java.util.Arrays;
import java.util.Random;

/**
 *
 */
public class BinarySearch {
    public static int binarySearch(int[] arr, int low, int high, int key) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (key == arr[mid]) {
            return mid;
        } else if (key < arr[mid]) {
            high = mid - 1;
            return binarySearch(arr, low, high, key);
        } else {
            low = mid + 1;
            return binarySearch(arr, low, high, key);
        }
    }

    public static void main(String[] args) {
        Random random=new Random();
        int[] num= {1,2,3,4,5,6,7,8,9,10};
        System.out.println("数组："+ Arrays.toString(num));
        System.out.println("查询结果:"+binarySearch(num,0,num.length,6));


    }
}
