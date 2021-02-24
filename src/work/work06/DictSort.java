package work.work06;

import java.util.*;

/**
 *字典排序.1234567全排列。
 */
public class DictSort {
    public static  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult = new ArrayList<>();
        for (int num : nums) {
            tempResult.add(num);
        }
        result.add(new ArrayList<>(tempResult));
        while (true) {
            // 第一个左边数小于右边数的位置
            int index = 0;
            for (int j = tempResult.size() - 1; j > 0; j--) {
                if (tempResult.get(j - 1) < tempResult.get(j)) {
                    index = j - 1;
                    break;
                }
            }
            // index右侧大于index位置值的最小位置
            int lastIndex = 0;
            boolean isFind = false;
            for (int i = tempResult.size() - 1; i > index; i--) {
                if (tempResult.get(i) > tempResult.get(index)) {
                    lastIndex = i;
                    isFind = true;
                    break;
                }
            }
            if (!isFind) {
                break;
            }
            // 交换index和lastIndex的值
            int temp = tempResult.get(index);
            tempResult.set(index, tempResult.get(lastIndex));
            tempResult.set(lastIndex, temp);
            // 将index后的元素翻转
            int len = tempResult.size() - index - 1;
            for (int k = 1, l = tempResult.size() - 1; k <= len / 2; k++) {
                int value = tempResult.get(k + index);
                tempResult.set(k + index, tempResult.get(l));
                tempResult.set(l, value);
                l--;
            }
            result.add(new ArrayList<>(tempResult));
        }
        return result;
    }

    public static void main(String[] args) {
         int []num={1,2,3,4,5,6,7};
        List<List<Integer>> a = permute(num);
        for(int i = 0;i < a.size();i++){
            System.out.println(a.get(i));
        }


    }


}
