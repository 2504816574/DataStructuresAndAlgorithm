package com.t06_sort;

import java.util.Arrays;

/**
 * @auther Ashen One
 * @Date 2021/3/1
 * 插入排序
 */
public class T03_InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        // 创建要给80000个的随机的数组
        // int[] arr = new int[80000];
        // for (int i = 0; i < 80000; i++) {
        //     // 生成一个[0, 8000000) 数
        //     arr[i] = (int) (Math.random() * 8000000);
        // }
        //
        // System.out.println("插入排序前");
        // Date data1 = new Date();
        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String date1Str = simpleDateFormat.format(data1);
        // System.out.println("排序前的时间是=" + date1Str);
        // //调用插入排序算法
        insertSort(arr);
        //
        // Date data2 = new Date();
        // String date2Str = simpleDateFormat.format(data2);
        // System.out.println("排序前的时间是=" + date2Str);

        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        //使用for循环来把代码简化
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            // 确定要插入的下标
            insertIndex = i;

            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex > 0 && insertVal < arr[insertIndex - 1]) {
                arr[insertIndex] = arr[insertIndex - 1];
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            // 举例：理解不了，我们一会 debug
            //这里我们判断是否需要赋值
            if (insertIndex != i) {
                arr[insertIndex] = insertVal;
            }

        }
    }
}
