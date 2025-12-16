package com.leetcode._2025_12;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2090. 半径为 k 的子数组平均值
 *
 * @author DHW
 * @date 2025/11/28 8: 47
 * @Version 1.0
*/
public class ProblemsNo2379 {

    @Test
    public void solution() {
        String blocks = "WBWBBBW";
        int k = 2;
        System.out.println("res = " + minimumRecolors(blocks, k));
    }

    public int minimumRecolors(String blocks, int k) {
        int ans = k;
        char[] charArray = blocks.toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == 'W') {
                count++;
            }
            int l = i - k + 1;
            if(l < 0) {
                continue;
            }
            ans = Math.min(ans, count);
            if(charArray[l] == 'W') {
                count--;
            }
        }
        return ans;
    }
}

