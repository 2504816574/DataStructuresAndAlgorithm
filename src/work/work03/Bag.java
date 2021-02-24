package work.work03;

/**
 * 给定 n 种物品，每种物品有对应的重量weight和价值value，一个容量为 maxWeight 的背包，
 * 问：应该如何选择装入背包的物品，使得装入背包中的物品的总价值最大？
 */
public class Bag {
    public static void main(String[] args) {
        int[] weight = { 3, 4, 6, 8, 9};
        int[] value = {2, 3, 5, 6, 7};
        int maxWeight = 20;
        System.out.println("最大价值为："+knapsack(weight,value,maxWeight));
    }

    public static int knapsack(int[] weight, int[] value, int maxweight){

        int n = weight.length;//物品种类
        //最大价值数组为maxvalue[n+1][maxWeight+1]，因为我们要从0开始保存
        int[][] maxvalue = new int[n+1][maxweight + 1];

        //重量为0时，最大价值价值为0
        for (int i = 0; i < maxweight + 1; i++) {
            maxvalue[0][i] = 0;
        }
        //物品种类为0时，最大价值为0
        for (int i = 0; i < n + 1; i++) {
            maxvalue[i][0] = 0;

        }
        //i：只拿前i件物品（这里的i因为取了0，所以对应到weight和value里面都是i-1号位置）
        //j：假设能取的总重量为j
        //n是物品件数
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= maxweight; j++) {
                //当前最大价值等于放上一件的最大价值
                maxvalue[i][j] = maxvalue[i-1][j];
                //如果当前件的重量小于总重量，可以放进去
                if (weight[i-1] <= j) {
                    //比较（不放这个物品的价值)
                    //（这个物品的价值 加上 当前能放的总重量减去当前物品重量时取前i-1个物品时的对应重量时候的最高价值）
                    int value1=maxvalue[i-1][j - weight[i-1]]+ value[i-1];
                    int value2=maxvalue[i-1][j];
                    maxvalue[i][j]=value1>value2?value1:value2;
                    /*if(value1>value2){
                        maxvalue[i][j]=value1;

                    }else {
                        maxvalue[i][j]=value2;
                    }*/

                }
            }
        }
        return maxvalue[n][maxweight];
    }


}
