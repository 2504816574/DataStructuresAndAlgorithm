package com.t015_graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图的两种遍历方法
 *
 * @author QQ 1023507448
 */
public class Graph {

    private static String[] node; //存储节点编号
    private static int[][] arc;   //存储边
    private static boolean[] flag;//存储节点是否被访问过

    //深度优先遍历
    private void depthFirstTraversal() {
        flag = new boolean[node.length];
        for (int i = 0; i < node.length; i++) {
            if (!flag[i]) {
                visitByRecursive(i);
            }
        }
    }

    //深度优先遍历-递归访问节点
    private void visitByRecursive(int i) {
        flag[i] = true; //设置为已访问过
        System.out.print(node[i] + " ");//在控制台打印
        for (int j = 0; j < node.length; j++) {
            if (!flag[j] && arc[i][j] == 1) {
                visitByRecursive(j);//递归
            }
        }

    }

    //广度优先遍历
    private void breadthFirstTraversal() {
        Queue<Integer> qu = new LinkedList<>();
        /*Queue是接口，只能new一个它的实现类，
          LinkedList实现了Queue */
        flag = new boolean[node.length];
        for (int i = 0; i < node.length; i++) {
            if (!flag[i]) {
                //元素入队列
                if (qu.offer(i)) {
                    //设置为已访问过
                    flag[i] = true;
                    //在控制台打印
                    System.out.print(node[i] + " ");
                }
                //若队列不为空
                while (!qu.isEmpty()) {
                    //出队列并返回值
                    int temp = qu.poll();
                    for (int j = 0; j < node.length; j++) {
                        if (!flag[j] && arc[temp][j] == 1) {
                            //元素入队列
                            if (qu.offer(j)) {
                                //设置为已访问过
                                flag[j] = true;
                                //在控制台打印
                                System.out.print(node[j] + " ");
                            }
                        }
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Graph gt = new Graph();
        node = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};//节点标记
        arc = new int[][]
                {
                        //边
                        {0, 1, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0}
                };
        System.out.println("深度优先搜索");
        gt.depthFirstTraversal();//调用深度优先搜索
        System.out.println("");
        System.out.println("广度优先搜索");
        gt.breadthFirstTraversal();//调用广度优先搜索
    }
}
