package other.sort.common;

import java.util.Random;

/**
 *生成随机数组
 */
public class Creat_Arrays {


    public static int[] creat_num(int size, int scope){
        int[] num=new int[size];
        Random random=new Random();
        for(int i=0;i<size;i++){
            num[i]=random.nextInt(scope);

        }
        return num;
    }
}
