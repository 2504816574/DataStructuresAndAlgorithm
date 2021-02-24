package work.work04;


/**
 * 快速排序
 * CSDN:https://blog.csdn.net/MoreWindows/article/details/6684558?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase
 */
public class Quicksort {
    public static void main(String[] args) {
        int[] count = new int[10];
        for (int i = 0; i < count.length; i++) {
            count[i] = (int) (Math.random() * 101);
        }
        System.out.print("排序前：");
        for (int num : count) {
            System.out.print(num + " ");
        }
        int[] a = quick_sort(count, 0, count.length - 1);
        System.out.println();
        System.out.print("排序后:");
        for (int num : a) {
            System.out.print(num + " ");
        }

    }

    public static int[] quick_sort(int s[], int l, int r) {
        if (l < r) {
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) {// 从右向左找第一个小于x的数
                    j--;
                }
                if (i < j) {
                    s[i++] = s[j];
                }


                while (i < j && s[i] < x) { // 从左向右找第一个大于等于x的数
                    i++;
                }
                if (i < j) {
                    s[j--] = s[i];
                }

            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
        return s;
    }
}


