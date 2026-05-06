package com.leetcode._2026_4;

import org.junit.Test;


/**
 * 777. 在 LR 字符串中交换相邻字符
 *
 * @author DHW
 * @date 2026/4/13 9: 06
 * @Version 1.0
 */
public class ProblemsNo777 {

    @Test
    public void solution() {
        String start = "RXXLRXRXL";
        String result = "XRLXXRRLX";
        System.out.println("res = " + canTransform(start, result));
    }

    public boolean canTransform(String start, String result) {
        if (!start.replace("X", "").equals(result.replace("X", ""))) {
            return false;
        }

        for (int i = 0, j = 0; i < start.length(); i++) {
            if(start.charAt(i) == 'X') {
                continue;
            }
            while(result.charAt(j) == 'X') {
                j++;
            }
            if (i != j && (start.charAt(i) == 'L') == (i < j)) {
                return false;
            }
            j++;
        }
        return true;
    }
}

