package other.data_structure.arrays;

import common.Creat_num;

import java.util.Arrays;

/**
 *数组-增
 */
public class TestArray02 {
    public static int[] array_insert(int[] array,int n,int num){//array:要修改的数组； n:第n位（从0开始）；num：要插入的数
        int[] newArr=new int[array.length+1]; //创建一个新的数组，长度是原数组长度+1
        for (int i=0;i<newArr.length;i++){ //把原数组中的数据全部复制到新数组中
            if(i<n){
                newArr[i]=array[i];//如果在n的前面，新数组[i]位=旧数组[i]位
            }else if(i==n){
                newArr[n]=num;//第n位插入
            }else{
                newArr[i]=array[i-1];//如果在n的后面,新数组[i]位=旧数组[i-1]位
            }
        }
        return newArr;
    }
    public static void main(String[] args) {
        int[] array= Creat_num.creat_num(10,10);
        System.out.println("原数组："+Arrays.toString(array));
        System.out.println("插入后："+Arrays.toString(array_insert(array,10,10)));
    }
}
