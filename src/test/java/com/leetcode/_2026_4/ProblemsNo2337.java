package com.leetcode._2026_4;

import org.junit.Test;


/**
 * 2337. 移动片段得到字符串
 *
 * @author DHW
 * @date 2026/4/10 9: 06
 * @Version 1.0
 */
public class ProblemsNo2337 {

    @Test
    public void solution() {
        String start = "_R";
        String target = "L_";
        System.out.println("res = " + canChange(start, target));
    }

    public boolean canChange(String start, String target) {
        if (!start.replace("_", "").equals(target.replace("_", ""))) {
            return false;
        }
        for (int i = 0, j = 0; i < start.length(); i++) {
            if(start.charAt(i) == '_') {
                continue;
            }
            while(target.charAt(j) == '_') {
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

