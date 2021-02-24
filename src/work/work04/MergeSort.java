package work.work04;

/**
 *合并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] count=new int[10];
        for (int i=0;i<count.length;i++){
            count[i]=(int)(Math.random()*101);
        }
        System.out.print("排序前：");
        for(int num:count){
            System.out.print(num+" ");
        }
        mergeSort(count,0,count.length-1);
        System.out.println();
        System.out.print("排序后:");
        for(int num:count){
            System.out.print(num+" ");
        }


    }
    public static void merge(int []a,int left,int mid,int right){
       int []tmp=new int[a.length];//辅助数组
       int p1=left,p2=mid+1,k=left;//p1、p2是检测指针，k是存放指针

       while(p1<=mid && p2<=right){
           if(a[p1]<=a[p2]) {
               tmp[k++] = a[p1++];
           }
           else {
               tmp[k++] = a[p2++];
           }
       }

       while(p1<=mid) tmp[k++]=a[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
       while(p2<=right) tmp[k++]=a[p2++];//同上

       //复制回原素组
       for (int i = left; i <=right; i++) {
           a[i] = tmp[i];
       }
   }

    public static void mergeSort(int [] a,int start,int end){
        if(start<end){//当子序列中只有一个元素时结束递归
            int mid=(start+end)/2;//划分子序列
            mergeSort(a, start, mid);//对左侧子序列进行递归排序
            mergeSort(a, mid+1, end);//对右侧子序列进行递归排序
            merge(a, start, mid, end);//合并
        }
    }

}
