package com.t07_search;

/**
 * @auther Ashen One
 * @Date 2021/3/2
 */
public class T04_FibonacciSearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};

        System.out.println("index=" + fibonacciSearch(arr, 89));

    }

    /**
     * 斐波那契数列
     *
     * @return 斐波那契数列
     */
    public static int[] fibonacci(int maxSize) {
        int[] f = new int[20];
        int i;
        f[0] = 1;
        f[1] = 1;
        for (i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }


    //编写斐波那契查找算法
    //使用非递归的方式编写算法

    /**
     * @param data 数组
     * @param key  我们需要查找的关键码(值)
     * @return 返回对应的下标，如果没有-1
     */
    public static int fibonacciSearch(int[] data, int key) {
        int low = 0;
        int high = data.length - 1;
        int mid;

        // 斐波那契分割数值下标
        int k = 0;

        // 序列元素个数
        int i;

        // 获取斐波那契数列
        int[] f = fibonacci(20);

        // 获取斐波那契分割数值下标
        while (data.length > f[k] - 1) {
            k++;
        }

        // 创建临时数组
        int[] temp = new int[f[k] - 1];
        System.arraycopy(data, 0, temp, 0, data.length);


        // 序列补充至f[k]个元素
        // 补充的元素值为最后一个元素的值
        for (i = data.length; i < f[k] - 1; i++) {
            temp[i] = temp[high];
        }

        while (low <= high) {
            // low：起始位置
            // 前半部分有f[k-1]个元素，由于下标从0开始
            // 则-1 获取 黄金分割位置元素的下标
            mid = low + f[k - 1] - 1;

            if (temp[mid] > key) {
                // 查找前半部分，高位指针移动
                high = mid - 1;
                // （全部元素） = （前半部分）+（后半部分）
                // f[k] = f[k-1] + f[k-1]
                // 因为前半部分有f[k-1]个元素，所以 k = k-1
                k = k - 1;
            } else if (temp[mid] < key) {
                // 查找后半部分，高位指针移动
                low = mid + 1;
                // （全部元素） = （前半部分）+（后半部分）
                // f[k] = f[k-1] + f[k-1]
                // 因为后半部分有f[k-1]个元素，所以 k = k-2
                k = k - 2;
            } else {
                // 如果为真则找到相应的位置
                // 出现这种情况是查找到补充的元素
                // 而补充的元素与high位置的元素一样
                return Math.min(mid, high);
            }
        }
        return -1;
    }

}
