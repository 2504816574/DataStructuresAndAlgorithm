package work.work11;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Horspool {
    /*    @param s 模式串
          @param b 主串
    */
    public List<Integer> horspool(String s, String b) {
        if (s.length() >= b.length() || s.length() == 0 || b.length() == 0) {
            return null;
        }

        List<Integer> startpos = new ArrayList<>();

        if (s.length() == 1) {
            char c = s.charAt(0);
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) == c) {
                    startpos.add(i);
                }
            }
            return startpos;
        }
        char[] arrB = b.toCharArray();
        int i = s.length() - 1;
        int step = 0;
        while (i < b.length()) {
            step = moveLen(i, arrB, s);
            if (step == 0) {
                startpos.add(i - s.length() + 1);
                i++;
            } else {
                i = i + step;
            }
        }
        return startpos;
    }


    public int moveLen(int i, char[] arrB, String s) {
        if (!s.contains(arrB[i] + ""))
            return s.length();
        else {
            if (s.charAt(s.length() - 1) != arrB[i]) {
                int j = s.length() - 1;
                while (j >= 0) {
                    if (s.charAt(j) == arrB[i]) {
                        return s.length() - 1 - j;
                    }
                    else {
                        j--;
                    }
                }
            } else {
                if (!s.substring(0, s.length() - 1).contains(arrB[i] + "")) {
                    for (int k = 1; k < s.length(); k++) {
                        if (!(s.charAt(s.length() - 1 - k) == arrB[i - k]))
                            return s.length();
                        return 0;
                    }
                } else {
                    for (int k = 1; k < s.length(); k++) {
                        if (!(s.charAt(s.length() - 1 - k) == arrB[i - k])) {
                            int j = s.length() - 2;
                            while (j >= 0) {
                                if (s.charAt(j) == arrB[i]) {
                                    return s.length() - j;
                                }
                                else {
                                    j--;
                                }
                            }
                        }
                        return 0;
                    }

                }
            }

        }
        return -1;
    }


}
