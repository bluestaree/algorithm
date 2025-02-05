package com.leetcode._2025_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1561. 你可以获得的最大硬币数目
 *
 * @author DHW
 * @date 2022/1/22 8: 40
 * @Version 1.0
*/
public class ProblemsNo1561 {

    @Test
    public void solution() {
        int[] piles = new int[]{9,8,7,6,5,1,2,3,4};
        System.out.println("res = " + maxCoins(piles));
    }

    public int maxCoins(int[] piles) {
        int res = 0;
        Arrays.sort(piles);
        int num = piles.length / 3;
        for (int i = piles.length - 2; num > 0; i-=2, num--) {
            res+=piles[i];
        }
        return res;
    }
}

