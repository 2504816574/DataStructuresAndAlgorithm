package finalExam;

import java.util.Scanner;

/**
 *矩阵相乘Strassen算法Java实现
 * 原理：https://www.cnblogs.com/hdk1993/p/4552534.html
 * 实现：https://blog.csdn.net/dawn_after_dark/article/details/78686488
 */
public class Strassen {
    public static void Strassen(int N, int[][] matrixA, int[][] matrixB, int[][] result) {
        if (N == 1) {
            result[0][0] = matrixA[0][0] * matrixB[0][0];
            return;
        }
        int halfSize = N / 2;
        //把矩阵matrixA、matrixB、result各分成大小相等的四部分
        int[][] A = new int[halfSize][halfSize];
        int[][] B = new int[halfSize][halfSize];
        int[][] C = new int[halfSize][halfSize];
        int[][] D = new int[halfSize][halfSize];
        int[][] E = new int[halfSize][halfSize];
        int[][] F = new int[halfSize][halfSize];
        int[][] G = new int[halfSize][halfSize];
        int[][] H = new int[halfSize][halfSize];
        int[][] C1 = new int[halfSize][halfSize];
        int[][] C2 = new int[halfSize][halfSize];
        int[][] C3 = new int[halfSize][halfSize];
        int[][] C4 = new int[halfSize][halfSize];
        //定义Strassen方法的七个变量
        int[][] P1 = new int[halfSize][halfSize];
        int[][] P2 = new int[halfSize][halfSize];
        int[][] P3 = new int[halfSize][halfSize];
        int[][] P4 = new int[halfSize][halfSize];
        int[][] P5 = new int[halfSize][halfSize];
        int[][] P6 = new int[halfSize][halfSize];
        int[][] P7 = new int[halfSize][halfSize];

        int[][] tempA = new int[halfSize][halfSize];
        int[][] tempB = new int[halfSize][halfSize];
        //给matrixA、matrixB分成的四部分分别赋值
        for (int i = 0; i < halfSize; i++) {
            for (int j = 0; j < halfSize; j++) {
                A[i][j] = matrixA[i][j];
                B[i][j] = matrixA[i][halfSize + j];
                C[i][j] = matrixA[i + halfSize][j];
                D[i][j] = matrixA[i + halfSize][j + halfSize];

                E[i][j] = matrixB[i][j];
                F[i][j] = matrixB[i][halfSize + j];
                G[i][j] = matrixB[i + halfSize][j];
                H[i][j] = matrixB[i + halfSize][j + halfSize];
            }
        }

        //P1=A(A-H)
        matrixSub(F, H, tempA);
        Strassen(halfSize, A, tempA, P1);
        //P2=（A+ B）H
        matrixAdd(A, B, tempA);
        Strassen(halfSize, tempA, H, P2);
        //P3=（C+D）E
        matrixAdd(C, D, tempA);
        Strassen(halfSize, E, tempA, P3);
        //P4=D（G-E）
        matrixSub(G, E, tempA);
        Strassen(halfSize, D, tempA, P4);
        //P5 =（A+D）（E+H)
        matrixAdd(A, D, tempA);
        matrixAdd(E, H, tempB);
        Strassen(halfSize, tempA, tempB, P5);
        //P6=（B-D）（G+H）
        matrixSub(B, D, tempA);
        matrixAdd(G, H, tempB);
        Strassen(halfSize, tempA, tempB, P6);
        //P7 =（A-C）（E+F）
        matrixSub(A, C, tempA);
        matrixAdd(E, F, tempB);
        Strassen(halfSize, tempA, tempB, P7);


        //C1=P5+P4-P2+P6
        matrixAdd(P5, P4, C1);
        matrixSub(C1, P2, C1);
        matrixAdd(C1, P6, C1);
        //C2=P1+P2
        matrixAdd(P1, P2, C2);
        //C3=P3+P4
        matrixAdd(P3, P4, C3);
        //C4=P1+P5-P3-P7
        matrixAdd(P5, P1, C4);
        matrixSub(C4, P3, C4);
        matrixSub(C4, P7, C4);


        for (int i = 0; i < halfSize; i++) {
            for (int j = 0; j < halfSize; j++) {
                result[i][j] = C1[i][j];
                result[i][j + halfSize] = C2[i][j];
                result[i + halfSize][j] = C3[i][j];
                result[i + halfSize][j + halfSize] = C4[i][j];
            }
        }
    }

    public static void matrixSub(int[][] matrixA, int[][] matrixB, int[][] result) {
        //矩阵减法
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA.length; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
    }

    public static void matrixAdd(int[][] matrixA, int[][] matrixB, int[][] result) {
        //矩阵加法
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA.length; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("矩阵大小N:");
        //获取矩阵大小
        int n = input.nextInt();
        int[][] matrixA = new int[n][n];
        int[][] matrixB = new int[n][n];
        int[][] result = new int[n][n];
        //获取矩阵A
        System.out.println("矩阵A：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixA[i][j] = input.nextInt();
            }
        }
        //获取矩阵B
        System.out.println("矩阵B: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixB[i][j] = input.nextInt();
            }
        }

        Strassen(n, matrixA, matrixB, result);

        //输出结果result
        System.out.println("A*B=");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != n - 1) {
                    System.out.print(result[i][j] + " ");
                } else System.out.println(result[i][j]);
            }
        }
    }
}





