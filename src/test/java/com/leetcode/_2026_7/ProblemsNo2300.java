package com.leetcode._2026_7;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2300. 咒语和药水的成功对数
 *
 * @author DHW
 * @date 2026/7/22 8: 38
 * @Version 1.0
 */
public class ProblemsNo2300 {

    @Test
    public void solution() {
        int[] spells = new int[]{3,1,2};
        int[] potions = new int[]{8,5,8};
        long success = 16;
        System.out.println("= res = " + successfulPairs(spells, potions, success));
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int l = 0;
            int r = m - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                long x = (long)potions[mid] * spell;
                if(x < success) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            ans[i] = m - l;
        }
        return ans;
    }
}

