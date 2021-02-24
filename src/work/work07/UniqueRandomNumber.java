package work.work07;

import java.util.Random;

/**
 *预排序检验数组元素唯一性。随机产生100个数。
 */
public class UniqueRandomNumber {
    public static void setNum(int[] source,int[] array ){
        Random random=new Random();
        int al=array.length;
        for(int i = 0; i <array.length; i++) {
            //随机产生一个位置
            int pos = random.nextInt(al);
            //获取该位置的值
            array[i] = source[pos];
            //改良：将最后一个数赋给被删除的索引所对应的值
            source[pos] = source[al - 1];
            //缩小随机数产生的范围
            al--;
        }



    }
    public static void main(String[] args) {
        int[] source=new int[100];
        int[] array=new int[100];
        for (int i=0;i<source.length;i++){
            source[i]=i;
        }
        setNum(source,array);
        System.out.println("随机数组为：");
        for (int i=0;i<array.length;i++){
            if (i!=0&&i%10==0){
                System.out.println();
            }
            System.out.print(array[i]+"\t");

        }


    }
}
