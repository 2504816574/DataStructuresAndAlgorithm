package work.work07;

import java.util.Arrays;

/**
 *
 */
public class MaxRandom {
    public static void main(String[] args){
        int[] num = new int[100];

        for(int i=0;i<100;i++){
            num[i]=(int) (Math.random()*10);
        }
        System.out.println("随机数为："+Arrays.toString(num));
        FindMax(num);
    }

    public static void FindMax(int[] num){
        int maxCount = -1,maxValue = -1;
        int [] count = new int [11];
        Arrays.sort(num);
        System.out.println("排序之后："+Arrays.toString(num));
        for(int index =0;index<num.length&&num[index]>=0;index ++)
        {
            count[num[index]]++;
            if(count[num[index]]>maxCount || (count[num[index]]==maxCount && maxValue<num[index]) )
            {
                maxCount = count[num[index]];
                maxValue = num[index];
            }
        }
        System.out.println("出现频率最多的数为："+ maxValue+",出现次数："+maxCount);

    }
}
