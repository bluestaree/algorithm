package com.leetcode._2024_12;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1366. 通过投票对团队排名
 *
 * @author DHW
 * @date 2024/12/29 18: 38
 * @Version 1.0
*/
public class ProblemsNo1366 {

    @Test
    public void solution() {
        String[] votes = new String[]{"ABC","ACB","ABC","ACB","ACB"};
        System.out.println("res = " + rankTeams(votes));
    }

    public String rankTeams(String[] votes) {
        int m = votes[0].length();
        int[][] cnt = new int[26][m + 1];
        for (String vote : votes) {
            for (int i = 0; i < m; ++i) {
                ++cnt[vote.charAt(i) - 'A'][i];
            }
        }
        Character[] s = new Character[m];
        for (int i = 0; i < m; ++i) {
            s[i] = votes[0].charAt(i);
        }
        Arrays.sort(s, (a, b) -> {
            int i = a - 'A', j = b - 'A';
            for (int k = 0; k < m; ++k) {
                if (cnt[i][k] != cnt[j][k]) {
                    return cnt[j][k] - cnt[i][k];
                }
            }
            return a - b;
        });
        StringBuilder ans = new StringBuilder();
        for (char c : s) {
            ans.append(c);
        }
        return ans.toString();
    }
}

