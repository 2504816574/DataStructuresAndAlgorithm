package other.data_structure.arrays;

import common.Creat_num;

import java.util.Arrays;

/**
 * 数组-查
 */
public class TestArray05 {

    //知道下标查数
    public static int array_search01(int[] array, int n) {
        int num = array[n];
        return num;
    }


    //知道数查下标
    //线性查找(顺序查找）
    public static int linear_Search(int[] array, int n) {//array:要查找的数组； n:要查的数n
        int address = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                address = i;
                break;
            }
        }
        return address;
    }

    //二分法查找
    //递归
    public static int binary_Search01(int[] array, int begin, int end, int num) {
        //初始中间位置
        if (num > array[end] || num < array[begin] || begin > end) {
            return -1;
        } else {
            int middle = (begin + end) / 2;
            if (array[middle] > num) {//比关键字大则关键字在左区域
                return binary_Search01(array, begin, middle - 1, num);
            } else if (array[middle] < num) {//比关键字小则关键字在右区域
                return binary_Search01(array, middle + 1, end, num);
            } else {//正好是关键字
                return middle;
            }
        }

    }

    //不使用递归实现（while循环）
    public static int binary_Search02(int[] array, int num) {
        int address = -1;
        int begin = 0;
        int end = array.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (array[mid] == num) {
                address = mid;
                break;
            } else if (array[mid] > num) {
                end = mid - 1;
            } else if (array[mid] < num) {
                begin = mid + 1;
            }
        }
        return address;
    }


    public static void main(String[] args) {
        int[] array = Creat_num.creat_num(10, 10);
        System.out.println("生成数组：" + Arrays.toString(array));
        int n = 2;//要查的位数||要查找的数
        System.out.println("第" + n + "位数为：" + array_search01(array, n));
        System.out.println("----------------------------");
        System.out.println("生成数组：" + Arrays.toString(array));
        System.out.println(n + "的下标为" + linear_Search(array, n));
        System.out.println("----------------------------");
        Arrays.sort(array);
        System.out.println("生成数组：" + Arrays.toString(array));
        System.out.println(n + "的下标为" + binary_Search01(array, 0, array.length - 1, n));
        System.out.println("----------------------------");
        System.out.println("生成数组：" + Arrays.toString(array));
        System.out.println(n + "的下标为" + binary_Search02(array, n));
    }
}
