package common;

import java.util.Random;

/**
 *封装点坐标，生成随机点
 */
public class Point {

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x;
   public int y;
    public static Point[] randomCoordinates(){//生成10个随机坐标
        Point[] points=new Point[10];
        Random random=new Random();
        for(int i=0;i<points.length;i++){
            int x=random.nextInt(100);
            int y=random.nextInt(100);
            points[i]=new Point(x,y);
        }
        System.out.print("生成随机点为：");
        for (Point point:points){
            System.out.print("("+point.x+","+point.y+")"+"\t");
        }
        System.out.println();

        return points;

    }
}
