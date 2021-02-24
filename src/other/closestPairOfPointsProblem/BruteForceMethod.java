package other.closestPairOfPointsProblem;

import common.Point;

/**
 * 最近点对问题-蛮力法
 *
 * 遍历点集中的所有点，算出所有点与其他点的距离，比较得出点集中距离最短的两点的距离，并将两点记录下来。
 *
 * d=√[(x1-x2)²+(y1-y2)²]
 *
 * CSDN:https://blog.csdn.net/chenxianqin2/article/details/79068975
 *
 * 时间复杂度：T(n) =an² + bn + c
 */
public class BruteForceMethod {
    public static double bruteForceMethod(Point[] points) {
        Double dmin = Math.pow((points[0].x - points[1].x), 2) + Math.pow((points[0].y - points[1].y), 2);//先取前两个点的点距为最小距离
        Point minPoint1 = points[0], minPoint2 = points[1];//设默认最短距离为 points[0]和 points[1]
        Double temp;//临时变量
        for (int i = 0; i < points.length - 1; i++) {//固定一个点，求与其他点距离的平方
            for (int j = i + 1; j < points.length; j++) {
                temp = Math.pow((points[i].x - points[j].x), 2) + Math.pow((points[i].y - points[j].y), 2);
                if (temp < dmin) {
                    dmin = temp;            //当发现更小的距离时，替换最小点距，并记录两个点的信息
                    minPoint1 = points[i];
                    minPoint2 = points[j];
                }
            }
        }
        System.out.println("最短距离的两个坐标为" + "(" + minPoint1.x + "," + minPoint1.y + ")" + " (" + minPoint2.x + "," + minPoint2.y + ")");
        return Math.sqrt(dmin);//最后开方，减少计算量
    }

    public static void main(String[] args) {
        System.out.println("最短距离为:" + bruteForceMethod(Point.randomCoordinates()));
    }
}
