package other.data_structure.stack;

import common.Creat_num;

import java.util.Arrays;

/**
 *栈：后进先出
 */
public class TestStack01 {


    public static int[] insert_Stack(int[] stack,int num){//压入元素
        int[] arrays=new int[stack.length+1];//创建一个新数组
        for (int i=0;i<stack.length;i++){
            arrays[i]=stack[i];//旧数组的值赋值到新数组
        }
        arrays[arrays.length-1]=num;
        return arrays;
    }
    public static int[] pop(int[] stack){//取栈顶元素;删除栈顶元素
        int[] arrays=new int[stack.length-1];//创建一个新数组
        for (int i=0;i<arrays.length;i++){
            arrays[i]=stack[i];//旧数组的值赋值到新数组
        }
        return arrays;
    }
    public static int peek(int[] stack) {//取栈顶元素;删除栈顶元素
        return stack[stack.length-1];
    }
    public static boolean isEmpty(int[] stack) {//取栈顶元素;删除栈顶元素
        return stack.length==0;
    }


    public static void main(String[] args) {
        int[] stack= Creat_num.creat_num(10,10);
        System.out.println("初始数组为"+Arrays.toString(stack));
        int num=4;
        System.out.println("压入栈顶元素"+num+":"+Arrays.toString(insert_Stack(stack,num)));
        System.out.println("取出栈顶元素"+Arrays.toString(pop(stack)));
        System.out.println("查看栈顶元素:"+peek(stack));
        System.out.println("判断栈是否为空:"+isEmpty(stack));
    }




}
