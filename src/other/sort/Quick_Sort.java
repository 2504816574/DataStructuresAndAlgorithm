package other.sort;

import common.Creat_num;

import java.util.Arrays;


/**
 * 快速排序
 * 快速排序由C. A. R. Hoare在1960年提出。它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，
 * 其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，
 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 *
 *1．i =L; j = R; 将基准数挖出形成第一个坑a[i]。
 *2．j--由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。
 *3．i++由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。
 *4．再重复执行2，3二步，直到i==j，将基准数填入a[i]中。
 *
 * CSDN:https://blog.csdn.net/MoreWindows/article/details/6684558
 * 视频：https://www.bilibili.com/video/BV1Tt411r75A?from=search&seid=15795872338856585627
 * <p>
 * 平均时间复杂度O(N*logN)
 */
public class Quick_Sort {
    public static int[] quick_Sort(int[] num, int l, int r) {
        if (l < r) {
            int i = l, j = r, x = num[l];
            while (i < j) {
                while (i < j && num[j] >= x) {//从右往左找第一个比temp（基准数）小的数
                    j--;
                }
                if (i < j) {
                    num[i++] = num[j];//Creat_num[l]=Creat_num[r];l++;     把小的数填到基准数的坑里（基准数已经提取出来），原来位置留下坑

                }
                while (i < j && num[i] < x) { //从左往右找第一个比temp（基准数）大的数
                    i++;
                }
                if (i < j) {
                    num[j--] = num[i];//Creat_num[r]=Creat_num[l];r++; 把大的数填到小的数的坑里
                }
            }
            num[i] = x;//此时左右遍历交于l=r点，把基准数填进这个坑
            quick_Sort(num, l, i - 1); // 递归调用
            quick_Sort(num, i + 1, r);
        }
        return num;
    }

    public static void main(String[] args) {
        int[] num = Creat_num.creat_num(10,100);
        System.out.println("排序前: "+Arrays.toString(num));
        System.out.println("排序后：" + Arrays.toString(quick_Sort(num,0,num.length-1)));
    }
}
