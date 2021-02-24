package other.data_structure.arrays;

import common.Creat_num;

import java.util.Arrays;

/**
 *数组-改
 */
public class TestArray04 {
    public static int[] array_update(int[] array,int n,int num){//array:要修改的数组； n:第n位（从0开始）；num：要修改为的数x
        array[n]=num;
        return array;
    }

    public static void main(String[] args) {
        int[] array= Creat_num.creat_num(10,10);
        System.out.println("修改前:"+ Arrays.toString(array));
        System.out.println("修改后:"+Arrays.toString(array_update(array,9,10)));
    }
}
