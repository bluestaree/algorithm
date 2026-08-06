package com.leetcode._2026_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 1291. 顺次数
 *
 * @author DHW
 * @date 2026/7/13 9: 13
 * @Version 1.0
 */
public class ProblemsNo1291 {

    @Test
    public void solution() {
        int low = 10000;
        int high = 100;
        System.out.println("= res = " + sequentialDigits(low, high));
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for (int d = 1; d <= 9; d++) {
            int x = d;
            for (int i = d; i <= 9 && x <= high; i++) {
                if (x >= low) {
                    ans.add(x);
                }
                x = x * 10 + i + 1;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}

