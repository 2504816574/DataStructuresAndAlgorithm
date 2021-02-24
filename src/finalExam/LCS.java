package finalExam;

/**
 * 最长公共子序列动态规划
 * CSDN:https://blog.csdn.net/hrn1216/article/details/51534607?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase
 * 代码：https://blog.csdn.net/fjssharpsword/article/details/51953952?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase
 */
public class LCS {
    // 假如返回两个字符串的最长公共子序列的长度
    public static int[][] longestCommonSubsequence(String str1, String str2) {
        int[][] matrix = new int[str1.length() + 1][str2.length() + 1];//建立二维矩阵
        // 初始化边界条件
        for (int i = 0; i <= str1.length(); i++) {
            matrix[i][0] = 0;//每行第一列置零
        }
        for (int j = 0; j <= str2.length(); j++) {
            matrix[0][j] = 0;//每列第一行置零
        }
        // 填充矩阵
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = (matrix[i - 1][j] >= matrix[i][j - 1] ? matrix[i - 1][j] : matrix[i][j - 1]);
                }
            }
        }
        return matrix;
    }

    //根据矩阵输出LCS
    public static void print(int[][] opt, String X, String Y, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            print(opt, X, Y, i - 1, j - 1);
            System.out.print(X.charAt(i - 1));
        } else if (opt[i - 1][j] >= opt[i][j]) {
            print(opt, X, Y, i - 1, j);
        } else {
            print(opt, X, Y, i, j - 1);
        }
    }

    public static void main(String[] args) {
        String str1 = "13456778";
        String str2 = "357486782";
        //计算lcs递归矩阵
        int[][] re = longestCommonSubsequence(str1, str2);
        //打印矩阵
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                System.out.print(re[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.print("最长公共子序列为：");
        //输出LCS
        print(re, str1, str2, str1.length(), str2.length());

    }
}
