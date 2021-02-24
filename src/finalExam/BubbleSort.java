package finalExam;

import java.util.Arrays;
import java.util.Random;

/**
 *冒泡排序
 */
public class BubbleSort {
    public static int[] bubbleSort(int[] count){
        Boolean flag;
        for (int i=0;i<count.length-1;i++){
            flag=false;
            for (int j=0;j<count.length-i-1;j++){
                if(count[j]>count[j+1]){
                    int max=count[j];
                    count[j]=count[j+1];
                    count[j+1]=max;
                    flag=true;
                }
            }
            if(flag){
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums=new int[10];
        Random random=new Random();
        for(int i=0;i<nums.length;i++){
            nums[i]=random.nextInt(100);
        }
        System.out.println("排序前："+ Arrays.toString(nums));
        System.out.println("排序后："+Arrays.toString(bubbleSort(nums)));
    }
}
