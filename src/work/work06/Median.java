package work.work06;

import java.util.Arrays;

/**
 * 计算中值和选择问题，随机产生10个数，找第7小的数。
 */
public class Median {
    public int ValSelect(int[] a, int l, int r, int k) {//l为需要处理的数组起点，r为终点，k为需要找到的第几小的值
        int i = l, j = r;     //i 是起点，最前面的数，j 是最后面的数
        while (i < j && a[j] >= a[i]){ //寻找到比a[i]大的 最小的j
            j--;}
        //j从最后一个向前循环,找到比a[i]小的数
        if (i < j) {                   //此时则将比a[i]小的数放到最前面
            swap(a, i, j);
        }
        while (i < j && a[i] <= a[j]) {   //此时是让i从前面往后递增，直到找到比a[j]小的数，注意此时的a[j]经过了交换，等于前面的a[i]也就是第一个数
            i++;
        }
        if (i < j) {
            swap(a, i, j);//再次交换
        }
        if (i < k) {
            return ValSelect(a, i + 1, r, k);//递归调用，i的值就是现在的数是第几小的数，k就是我们需要的第几小的数
        } else if (i > k) {
            return ValSelect(a, l, i - 1, k);
        } else { return a[i]; }         //此处就是i=k，就是找到了我们需要的数，返回该值

    }

    public void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Median median = new Median();
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 101);
        }
        System.out.println("随机数组：" + Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("进行排序:" + Arrays.toString(a));
        System.out.println("第七个数为：" + median.ValSelect(a, 0, a.length - 1, 6));
    }

}
