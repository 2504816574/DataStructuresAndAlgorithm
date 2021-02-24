package other.data_structure.arrays;


import java.util.Arrays;

/**
 *数组
 *
 *数组长度不可变
 */
public class TestArray01 {
    public static void main(String[] args) {
        int[] n = new int[10];//创建一个长度为10的数组
        System.out.println("n.length:" + n.length);//获取数组长度


        //数组赋值
        //方法一：直接赋值
        n= new int[]{1, 2, 3, 4, 45, 5,4};

        //方法二：挨个赋值
        for (int i = 0; i < n.length; i++) {
           n[i]=i;
        }


        //数组遍历
        //方法一：
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }
        System.out.println();
        //方法二：
        System.out.println(Arrays.toString(n));


    }
}
