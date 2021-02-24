package other.sort;


import other.sort.common.Creat_Arrays;

import java.util.Arrays;

/**
 *选择排序
 *从头至尾扫描序列，找出最小的一个元素，和第一个元素交换，接着从剩下的元素中继续这种选择和交换方式，最终得到一个有序序列。
 *
 * CSDN:https://blog.csdn.net/changhangshi/article/details/82740541?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-1&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-1
 * 视频：https://www.bilibili.com/video/BV1RJ41167sB?from=search&seid=13244993452829576035
 *
 * 平均时间复杂度O(n2)
 */
public class Select_Sort {
    public static int[] selectSort(int[] num){
        int temp;
        for (int i=0;i<num.length;i++){
            for (int j=i+1;j<num.length;j++){
                if(num[j]<num[i]){
                    temp=num[j];
                    num[j]=num[i];
                    num[i]=temp;
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        int[] num= Creat_Arrays.creat_num(10,100);
        System.out.println("排序前: "+Arrays.toString(num));
        System.out.println("排序后: " + Arrays.toString(selectSort(num)));

    }
}
