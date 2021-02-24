package finalExam;

import java.util.Arrays;

/**
 * 原理：https://www.cnblogs.com/cobbliu/archive/2012/05/29/2524244.html
 * CSDN：https://blog.csdn.net/swagle/article/details/24269403
 * 其他方法：src\work\work11\Horspool.java
 */
public class Horspool {
    /**
     * 输入： 模式p[0..m-1]以及一个可能出现字符的字母表
     * 输出: 以字母表中字符为索引的数组table[0..size-1]
     * 把模式串没有的字符table设为m，有的设为m-1-i，i以模式中当前字符位置最小值
     *
     * @param m 模式串
     * @return
     */
    public static int[] shiftTable(char[] m) {
        int[] table = new int[255];
        int len = m.length;

        // 把模式串没有的字符table设为m，有的设为m-1-i，i以模式中当前字符位置最小值
        Arrays.fill(table, len);

        for (int i = 0; i < len - 1; i++) {
            table[m[i]] = len - 1 - i;
        }
        return table;

    }

    /**
     * 匹配过程
     *
     * @param m 模式串
     * @param t 文本串
     * @return
     */
    public static int horspoolMatching(char[] m, char[] t) {
        int[] table = shiftTable(m);
        int mLen = m.length;
        int tLen = t.length;
        // 当前匹配模式串位置，由末尾开始匹配
        int i = mLen;
        // 匹配模式字符串字符个数
        int k;
        while (i < tLen) {
            k = 0;
            while (k < mLen && t[i - 1 - k] == m[mLen - 1 - k]) {
                k++;
            }
            // 当匹配个数等于模式串个数
            if (k == mLen) {
                return i - mLen;
            } else {
                i += table[t[i - 1]];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String mS = "abcbdc";
        String tS = "sdfabcdabcbdcsd";
        // 打印返回的下标值
        System.out.println(horspoolMatching(mS.toCharArray(), tS.toCharArray())); //输出7
    }
}
