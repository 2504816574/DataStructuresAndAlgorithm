package work.work05;

import java.util.Scanner;

/**
 * 循环赛日程表
 */
public class CircleCompetition {

    private int array[][];



    public CircleCompetition(int n){
        array=new int[n][n];
        for(int i=0;i<n;i++) {
            array[i][0] = i + 1;
        }
    }
    /*
     * a代表待求矩阵行的起始下标，b代表待求矩阵行的终止下标，下同
     * i代表待求矩阵列的起始下标，j代表待求矩阵列的终止下标，下同
     */
    public void arrange(int a,int b,int i,int j){
        if(i<j){
            arrange(a, (a+b-1)/2, i, (j+i-1)/2);
            arrange((a+b+1)/2, b, i, (j+i-1)/2);
            merge(a,(a+b-1)/2, i,(j+i-1)/2, "top");
            merge((a+b+1)/2, b, i, (j+i-1)/2, "bottom");
        }
    }

    public void merge(int a,int b,int i,int j,String s){
        int lenth=b-a+1;
        if(s.equals("top")){
            for(int p=a;p<=b;p++){
                for(int q=i;q<=j;q++) {
                    array[p + lenth][q + lenth] = array[p][q];
                }
            }
        }
        else if(s.equals("bottom")){
            for(int p=a;p<=b;p++){
                for(int q=i;q<=j;q++) {
                    array[p - lenth][q + lenth] = array[p][q];
                }
            }
        }
    }

    public void print(){
        int n=array.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(array[i][j]+"\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.print("请输入选手的个数n(n=2^k):");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        CircleCompetition circleCompetition=new CircleCompetition(n);
        circleCompetition.arrange(0, n-1, 0, n-1);
        circleCompetition.print();
    }

}
