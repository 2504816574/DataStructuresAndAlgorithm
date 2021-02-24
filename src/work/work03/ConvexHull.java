package work.work03;

/**
 * 凸包问题
 * CSDN:https://blog.csdn.net/qq_39630587/article/details/79249747?utm_source=blogxgwz1
 */
public class ConvexHull {
/*    public static void main(String[] args) {
        Point[] points = new Point[10];
        for (int i = 0; i < points.length; i++) {
            int x = (int) (Math.random() * 101);
            int y = (int) (Math.random() * 101);
            points[i] = new Point(x, y);
        }
        System.out.println("生成随机点为：");
        for (Point point : points) {
            System.out.print("(" + point.x + "," + point.y + ")  ");
        }
        System.out.println();
        System.out.println("符合的坐标对为：");
        int a, b, c;
        Boolean flag = false;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                a = points[j].y - points[i].y;
                b = points[i].x - points[j].x;
                c = points[i].x * points[j].y - points[j].x * points[i].y;
                int num1 = 0;// ax+by>=c
                int num2 = 0;// ax+by<=c
                for (int k = 0; k < points.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    if (a * points[k].x + b * points[k].y > c) {
                        num1++;

                    } else if (a * points[k].x + b * points[k].y == c) {
                        num1++;
                        num2++;

                    } else if (a * points[k].x + b * points[k].y < c) {
                        num2++;
                    }
                }
                if (num1 == points.length - 2 || num2 == points.length - 2) {
                    System.out.println("(" + points[i].x + "," + points[i].y + ") " + " (" + points[j].x + "," + points[j].y + ")");
                }
                num1 = 0;
                num2 = 0;
            }
        }


    }*/

    //蛮力法解决凸包问题，返回点集合中凸多边形的点集合
    public static Point[] getConvexPoint(Point[] A) {
        Point[] result = new Point[A.length];
        int len = 0;//用于计算最终返回结果中是凸包中点的个数
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (j == i) {//除去选中作为确定直线的第一个点
                    continue;
                }
                int[] judge = new int[A.length]; //存放点到直线距离所使用判断公式的结果
                for (int k = 0; k < A.length; k++) {
                    int a = A[j].getY() - A[i].getY();
                    int b = A[i].getX() - A[j].getX();
                    int c = (A[i].getX()) * (A[j].getY()) - (A[i].getY()) * (A[j].getX());
                    judge[k] = a * (A[k].getX()) + b * (A[k].getY()) - c;  //根据公式计算具体判断结果
                }
                if (JudgeArray(judge)) {  // 如果点均在直线的一边,则相应的A[i]是凸包中的点
                    result[len++] = A[i];
                    break;
                }
            }
        }
        Point[] result1 = new Point[len];
        for (int m = 0; m < len; m++) {
            result1[m] = result[m];
        }
        return result1;

    }

    //判断数组中元素是否全部大于等于0或者小于等于0，如果是则返回true，否则返回false
    public static boolean JudgeArray(int[] Array) {
        boolean judge = false;
        int len1 = 0, len2 = 0;

        for (int i = 0; i < Array.length; i++) {
            if (Array[i] > 0) {
                len1++;
            } else if (Array[i] < 0) {
                len2++;
            } else {
                len1++;
                len2++;
            }
        }
        if (len1 == Array.length || len2 == Array.length) {
            judge = true;
        }
        return judge;
    }

    public static void main(String[] args) {
        Point[] points = new Point[10];
        for (int i = 0; i < points.length; i++) {
            int x = (int) (Math.random() * 101);
            int y = (int) (Math.random() * 101);
            points[i] = new Point(x, y);
        }
        System.out.println("随机点集合points：");
        for (Point point : points) {
            System.out.print("(" + point.getX() + "," + point.getY() + ")  ");
        }
        System.out.println();
        System.out.println("集合points中满足凸包的点集为：");
        Point[] result=getConvexPoint(points);
        for (Point point : result) {
            System.out.print("(" + point.getX() + "," + point.getY() + ")  ");
        }


    }
}

class Point {
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


}

