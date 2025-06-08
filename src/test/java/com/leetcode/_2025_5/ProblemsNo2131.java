package com.leetcode._2025_5;

import org.junit.Test;


/**
 * 2131. 连接两字母单词得到的最长回文串
 *
 * @author DHW
 * @date 2025/5/25 10: 51
 * @Version 1.0
*/
public class ProblemsNo2131 {

    @Test
    public void solution() {
        String[] words = new String[]{"lc","cl","gg"};
        System.out.println("res = " + longestPalindrome(words));
    }

    public int longestPalindrome(String[] words) {
        int res = 0;
        int[][] dominoes = new int[27][27];
        for (int i = 0; i < words.length; i++) {
            int x = words[i].charAt(0) - 'a';
            int y = words[i].charAt(1) - 'a';
            dominoes[x][y]++;
        }

        boolean useTag = true;
        for (int i = 0; i < dominoes.length; i++) {
            for (int j = 0; j < dominoes[i].length; j++) {
                if (i == j) {
                    if((dominoes[i][j] & 1) == 1 && useTag) {
                        res += 2;
                        useTag = false;
                    }
                    res += (dominoes[i][j] / 2) * 4;
                } else if(dominoes[j][i] > 0) {
                    res += Math.min(dominoes[j][i], dominoes[i][j]) * 4;
                    dominoes[j][i] = 0;
                    dominoes[i][j] = 0;
                }
            }
        }
        return res;
    }
}

