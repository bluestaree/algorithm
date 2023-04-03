package com.leetcode._2023_3;

import org.junit.Test;


/**
 * 2379. 得到 K 个黑块的最少涂色次数
 *
 * @author DHW
 * @date 2023/3/9 14:55
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
        int l = 0;
        int r = 0;
        int count = 0;
        while(r < k) {
            count += blocks.charAt(r) == 'W' ? 1 : 0;
            r++;
        }

        int res = count;

        while(r < blocks.length()) {
            count += blocks.charAt(r) == 'W' ? 1 : 0;
            count -= blocks.charAt(l) == 'W' ? 1 : 0;
            res = Math.min(res, count);
            r++;
            l++;
        }
        return res;
    }
}
