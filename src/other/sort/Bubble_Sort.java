package other.sort;

import other.sort.common.Creat_Arrays;

import java.util.Arrays;

/**
 * 冒泡排序
 * 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 *
 * CSDN:https://blog.csdn.net/Java_3y/article/details/79589117
 * 视频：https://www.bilibili.com/video/BV1c4411a7D6?from=search&seid=4556954171338027336
 *
 * 平均时间复杂度O(n2)
 */
public class Bubble_Sort {
    public static int[] bubble_Sort(int[] num) {
        Boolean flag;
        int temp;
        for (int i = 0; i < num.length - 1; i++) {//外层循环是排序的趟数
            flag = false;    //每比较一趟就重新初始化为false
            for (int j = 0; j < num.length - i - 1; j++) { //内层循环是当前趟数需要比较的次数
                if (num[j] > num[j + 1]) { //前一位与后一位与前一位比较，如果前一位比后一位要大，那么交换
                    temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                    flag = true;//如果进到这里面了，说明发生置换了

                }
            }if (flag = false) {//如果比较完一趟没有发生置换，那么说明已经排好序了，不需要再执行下去了
                break;
            }

        }

        return num;
    }

    public static void main(String[] args) {
        int[] num=Creat_Arrays.creat_num(10,100);
        System.out.println("排序前: "+Arrays.toString(num));
        System.out.println("排序后: " + Arrays.toString(bubble_Sort(num)));

    }

}
