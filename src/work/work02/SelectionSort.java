package work.work02;

/**
 *选择排序法
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] count=new int[10];
        for (int i=0;i<10;i++){
            count[i]=(int)(Math.random()*101);
        }
        System.out.println("排序前：");
        for (int num:count){
            System.out.print(num+" ");
        }
        for (int i=0;i<count.length;i++){
            for (int j=i+1;j<count.length;j++){
                if(count[j]<count[i]){
                    int min=count[j];
                    count[j]=count[i];
                    count[i]=min;
                }
            }
        }
        System.out.println();
        System.out.println("排序后：");
        for (int num:count){
            System.out.print(num+" ");
        }

    }
}
