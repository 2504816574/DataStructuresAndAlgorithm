package work.work02;

/**
 *冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
       int[] count=new int[10];
        for (int i=0;i<count.length;i++){
            count[i]=(int)(Math.random()*101);
        }
        System.out.println("排序前：");
        for (int num:count){
            System.out.print(num+" ");
        }

        Boolean flag=false;
        for (int i=0;i<count.length-1;i++){
            for (int j=0;j<count.length-i-1;j++){
                if(count[j]>count[j+1]){
                    int max=count[j];
                    count[j]=count[j+1];
                    count[j+1]=max;
                    flag=true;
                }
            }
            if(flag){
               continue;
            }
        }
        System.out.println();
        System.out.println("排序后：");
        for (int num:count){
            System.out.print(num+" ");
        }
    }

}
