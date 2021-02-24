package finalExam;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 * CSDN：https://blog.csdn.net/MoreWindows/article/details/6684558?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase
 */
public class QuickSsort {
    public static void quick_sort(int[] s, int l, int r) {
        if (l < r) {
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) {// 从右向左找第一个小于x的数
                    j--;
                }
                if (i < j) {
                    s[i] = s[j];
                    i++;
                }
                while (i < j && s[i] < x) { // 从左向右找第一个大于等于x的数
                    i++;
                }
                if (i < j) {
                    s[j] = s[i];
                    j--;
                }
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[10];
        Random random=new Random();
        for(int i=0;i<nums.length;i++){
            nums[i]=random.nextInt(100);
        }
        System.out.println("排序前："+ Arrays.toString(nums));
        quick_sort(nums,0,nums.length-1);
        System.out.println("排序后："+Arrays.toString(nums));


    }
}
