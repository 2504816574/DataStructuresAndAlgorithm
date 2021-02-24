package other.data_structure.arrays;

import common.Creat_num;

import java.util.Arrays;

/**
 *数组-删
 */
public class TestArray03 {
    public static int[] array_delete(int[] array,int n){//array：要修改的数组;n；第n位(从0开始)
        int[] newArr=new int[array.length-1];
        for (int i=0;i<newArr.length;i++){
            if(i<n){
                newArr[i]=array[i];
            }else {
                newArr[i]=array[i+1];
            }
        }

        return newArr;
    }

    public static void main(String[] args) {
        int[] array= Creat_num.creat_num(10,10);
        System.out.println("修改前："+ Arrays.toString(array));
        System.out.println("修改后："+Arrays.toString(array_delete(array,9)));

    }
}
