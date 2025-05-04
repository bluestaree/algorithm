package com.leetcode._2025_5;

import org.junit.Test;


/**
 * 1128. 等价多米诺骨牌对的数量
 *
 * @author DHW
 * @date 2025/5/4 10: 19
 * @Version 1.0
*/
public class ProblemsNo1128 {

    @Test
    public void solution() {
        int[][] dominoes = new int[][]{new int[]{1,2},new int[]{5,6},new int[]{9,10}};
        System.out.println("res = " + numEquivDominoPairs(dominoes));
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] cnt = new int[100];
        int res = 0;
        for (int[] e : dominoes) {
            int x = e[0] > e[1] ? e[0] * 10 + e[1]: e[1] * 10 + e[0];
            res += cnt[x]++;
        }

        return res;
    }
}

