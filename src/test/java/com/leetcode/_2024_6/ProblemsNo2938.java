package com.leetcode._2024_6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 2938. 区分黑球与白球
 *
 * @author DHW
 * @date 2024/6/6 9:24
 * @Version 1.0
*/
public class ProblemsNo2938 {

    @Test
    public void solution() {
        String s = "100";
        System.out.println("res = " + minimumSteps(s));
    }

    public long minimumSteps(String s) {
        long res = 0l;
        long count = 0l;
        for (char c : s.toCharArray()) {
            if(c == '0') {
               res += count;
            } else {
                count++;
            }

        }
        return res;
    }
}

