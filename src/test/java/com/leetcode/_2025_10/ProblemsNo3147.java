package com.leetcode._2025_10;

import org.junit.Test;


/**
 * 3147. 从魔法师身上吸取的最大能量
 *
 * @author DHW
 * @date 2025/10/10 9: 35
 * @Version 1.0
*/
public class ProblemsNo3147 {

    @Test
    public void solution() {
        int[] energy =  new int[]{-2,-3,-1};
        int k = 2;
        System.out.println("res = " + maximumEnergy(energy, k));
    }

    public int maximumEnergy(int[] energy, int k) {
        int ans = Integer.MIN_VALUE;
        int n = energy.length;
        for (int i = n - k; i < n; ++i) {
            for (int j = i, s = 0; j >= 0; j -= k) {
                s += energy[j];
                ans = Math.max(ans, s);
            }
        }
        return ans;
    }

}

