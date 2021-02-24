package other.sort;

import other.sort.common.Creat_Arrays;

import java.util.Arrays;

/**
 *插入排序
 *
 * 基本思想：
 * 在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
 *
 * 平均时间复杂度：O(n2)
 *
 * CSDN:https://blog.csdn.net/qq_37623612/article/details/80312121?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2
 *视频：https://www.bilibili.com/video/BV1GW411H7y2?from=search&seid=2829599342304961554
 */
public class Insert_Sort {
    public static int[] insert_sort(int[] num){
        int temp;
        for(int i=1;i<num.length-1;i++){//假设前面i个数已排好
            for(int j=i+1;j>0;j--){//第i+1个数跟前面i个数比较，如果存在比它大的数，则交换位置
                if(num[j]<num[j-1]){
                    temp=num[j];
                    num[j]=num[j-1];
                    num[j-1]=temp;
                }
            }

        }
        return num;
    }

    public static void main(String[] args) {
        int[] num=Creat_Arrays.creat_num(10,100);
        System.out.println("排序前: "+Arrays.toString(num));
        System.out.println("排序后: " + Arrays.toString(insert_sort(num)));

    }

}
