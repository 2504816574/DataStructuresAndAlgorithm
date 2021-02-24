package other.bruteForceMethod;

import common.Point;

import java.util.ArrayList;

import static common.Point.randomCoordinates;

/**
 * 凸包问题-蛮力法
 *
 * <p>
 * •根据中学的几何知识：
 * ax+by=c
 * a=y2-y1 b=x1-x2 c=x1y2-y1x2
 * •两个点构成一条直线，直线把平面分为两个半平面：其 中一个平面上所有的点都满足ax+by-c>0，而另一个半平 面中的点满足ax+by-c<0。
 * <p>
 * CSDN:https://blog.csdn.net/yangkunpengD/article/details/51336453
 * <p>
 * 时间复杂度：O(n³）
 */
public class ConvexHull {
    public static ArrayList<Point> convexHull(Point[] points) {
        ArrayList<Point> point = new ArrayList<>();
        int a, b, c;

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                a = points[j].y - points[i].y;
                b = points[i].x - points[j].x;
                c = points[i].x * points[j].y - points[j].x * points[i].y;
                int num1 = 0;// ax+by>=c
                int num2 = 0;// ax+by<=c
                for (int k = 0; k < points.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    } else {
                        if (a * points[k].x + b * points[k].y > c) {
                            num1++;

                        } else if (a * points[k].x + b * points[k].y == c) {
                            num1++;
                            num2++;

                        } else if (a * points[k].x + b * points[k].y < c) {
                            num2++;
                        }
                    }
                }
                if ((num1 == points.length - 2 || num2 == points.length - 2)) {
                    if (point.indexOf(points[i]) == -1) {
                        point.add(points[i]);
                    }
                    if (point.indexOf(points[j]) == -1) {
                        point.add(points[j]);
                    }
                }

            }
        }

        return point;
    }

    public static void main(String[] args) {
        ArrayList<Point> point = convexHull(randomCoordinates());
        System.out.print("符合的坐标为:");
        for (int i = 0; i < point.size(); i++) {
            System.out.print("("+point.get(i).x+","+point.get(i).y+")"+"\t");
        }

    }

}
