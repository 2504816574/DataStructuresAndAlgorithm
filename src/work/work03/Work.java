package work.work03;

import java.util.Scanner;

/**
 * 设有n件工作分配给n个人。将工作i分配给第j个人所需的费用为money[i][j] 。
 * 设计一个算法，对于给定的工作费用，为每一个人都分配1 件不同的工作，并使总费用达到最小。
 */
public class Work {
    static int n;//定义n个人n个工作
    static int[][] money;//接收所需费用
    static int[] task;//用来标记第i个任务是否已经有人做了
    static int minSumMoney;//记录最小的花销

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();//接收有n个工作,n个人
        task = new int[n];
        money = new int[n][n];
        if (scanner.hasNextInt()) {
            for (int i = 0; i < n; i++) {//从控制台获取二维数组费用
                for (int j = 0; j < n; j++) {
                    money[i][j] = scanner.nextInt();
                }
            }
        }
        recursion(1, 0);
        System.out.println(minSumMoney);
    }

    public static void recursion(int i, int nowSumMoney) {
        if (i > n) {
            for (int j = 0; j < n; j++) {
                //当前已经大于最小值的情况，直接剪枝
                if (minSumMoney != 0 && nowSumMoney > minSumMoney) {
                   
                    return;
                } else if (task[j] == 0) {//当这个任务还没有人做
                    //标记这个任务由当前的人来做，防止同一任务被多个人做
                    task[j] = 1;
                    //继续往下递归下一个任务
                    recursion(i + 1, nowSumMoney + money[i][j]);
                    //递归结束后解除任务的锁定
                    task[j] = 0;
                }//如果这个任务已经有人做了（被标记过了）

            }
        } else {
            if (minSumMoney != 0)
                minSumMoney = Math.min(minSumMoney, nowSumMoney);
            else {
                minSumMoney = nowSumMoney;
            }
        }
    }


}
