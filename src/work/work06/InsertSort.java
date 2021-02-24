package work.work06;

import java.util.Arrays;

/**
 *直接插入排序
 */
public class InsertSort {
    public static int[] insertSort(int[] count){
        //直接插入排序
        for(int i=1;i<count.length;i++) { //把第一个数看成是有序的 ，所以从第二个数开始循环。
            for(int j = i-1;j>=0;j--) {  //内层循环 是从外层 循序的 前一个数开始 比
                if(count[j]>count[j+1]) {
                  int temp = count[j];
                    count[j] =count[j+1];
                    count[j+1] =temp;

                }else break;  //把 第 前 j+1个数个数 看成 是有序的 ，所以当  arr[j]<=arr[j+1]  时 直接头跳出 ，此时 前 j+2个数以满足有序
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] count=new int[10];//产生随机数
        for (int i=0;i<count.length;i++){
            count[i]=(int)(Math.random()*101);
        }
        System.out.println("排序前："+Arrays.toString(count)); //打印 数组  调用Arrays的 toString 静态方法打印数组
        System.out.println("排序后："+Arrays.toString(insertSort(count)));

    }
}
