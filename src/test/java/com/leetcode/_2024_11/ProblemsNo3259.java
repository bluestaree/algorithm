package com.leetcode._2024_11;

import org.junit.Test;


/**
 * 3259. 超级饮料的最大强化能量
 *
 * @author DHW
 * @date 2024/11/1 10: 08
 * @Version 1.0
*/
public class ProblemsNo3259 {

    @Test
    public void solution() {
        int[] energyDrinkA = new int[]{7,4,1};
        int[] energyDrinkB = new int[]{7,4,1};
        System.out.println("res = " + maxEnergyBoost(energyDrinkA, energyDrinkB));
    }

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[][] f = new long[n][2];
        f[0][0] = energyDrinkA[0];
        f[0][1] = energyDrinkB[0];
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i-1][0] + energyDrinkA[i], f[i-1][1]);
            f[i][1] = Math.max(f[i-1][1] + energyDrinkB[i], f[i-1][0]);
        }
        return Math.max(f[n-1][0], f[n-1][1]);
    }
}

