package work.work02;

import java.util.Random;

/**
 *
 */
public class NearestPoint {
    public static void main(String[] args) {
        Point[] points=new Point[10];
        Random random=new Random();
        for(int i=0;i<points.length;i++){
            int x=random.nextInt(100);
            int y=random.nextInt(100);
            points[i]=new Point(x,y);
        }
        System.out.println("生成随机点为：");
        for (Point point:points){
            System.out.print("("+point.x+","+point.y+")  ");
        }
        Double dmin=Math.sqrt(100*100+100*100);
        System.out.println();
        System.out.println("默认最长："+dmin);
        for (int i=0;i<points.length;i++){
            for (int j=i+1;j<points.length-1;j++){
                Double n1= Math.pow(points[i].x-points[j].x, 2);
                Double n2=Math.pow(points[i].y-points[j].y, 2);
                Double d=Math.sqrt(n1+n2);
                dmin=Math.min(dmin,d);
            }
        }
        System.out.println("最短距离为"+dmin);
    }
}
class Point {
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x;
    int y;


}
