package com.leetcode._2025_7;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2410. 运动员和训练师的最大匹配数
 *
 * @author DHW
 * @date 2025/7/13 10: 10
 * @Version 1.0
*/
public class ProblemsNo2410 {

    @Test
    public void solution() {
        int[] players = new int[]{4,7,9};
        int[] trainers = new int[]{8,2,5,8};
        System.out.println("res = " + matchPlayersAndTrainers(players, trainers));
    }

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m = players.length, n = trainers.length;
        for (int i = 0, j = 0; i < m; ++i, ++j) {
            while (j < n && trainers[j] < players[i]) {
                ++j;
            }
            if (j == n) {
                return i;
            }
        }
        return m;
    }
}

