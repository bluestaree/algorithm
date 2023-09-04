package com.leetcode._2023_8;

import org.junit.Test;

import java.util.ArrayList;


/**
 * 2337. 移动片段得到字符串
 *
 * @author DHW
 * @date 2023/8/21 9:31
 * @Version 1.0
*/
public class ProblemsNo2337 {

    @Test
    public void solution() {
        String start = "R_";
        String target = "LR";
        System.out.println("res = " + canChange(start, target));
    }

    public boolean canChange(String start, String target) {
        int len = start.length();
        char[] sc = start.toCharArray();
        char[] tc = target.toCharArray();
        for (int i = 0; i < len; i++) {
            char c1 = sc[i];
            char c2 = tc[i];
            if(c1 != c2) {
                if(c1 == '_') {
                    if(c2 == 'R') {
                        return false;
                    }
                    if (!findAndSwap(len, sc, i, 'R', c2)) return false;
                } else {
                    if(c1 == 'L') {
                        return false;
                    }
                    if (!findAndSwap(len, sc, i, 'L', c2)) return false;
                }
            }
        }
        return true;
    }

    private boolean findAndSwap(int len, char[] sc, int i, char l, char c) {
        int mark = -1;
        for (int j = i + 1; j < len; j++) {
            if (sc[j] == l) {
                return false;
            }
            if (sc[j] == c) {
                mark = j;
                break;
            }
        }
        if (mark == -1) {
            return false;
        }
        char temp = sc[mark];
        sc[mark] = sc[i];
        sc[i] = temp;
        return true;
    }
}
