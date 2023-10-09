package com.leetcode._2023_9;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * LCP 50. 宝石补给
 *
 * @author DHW
 * @date 2023/9/15 9:07
 * @Version 1.0
*/
public class ProblemsNoLCP50 {

    @Test
    public void solution() {
        int[] gem = new int[]{1,3,4};
        int[][] operations = new int[][]{new int[]{3,5}, new int[]{2,7}};
        System.out.println("res = " + giveGem(gem, operations));
    }

    public int giveGem(int[] gem, int[][] operations) {
        int n = gem.length;
        for (int i = 0; i < operations.length; i++) {
            int a = operations[i][0];
            int b = operations[i][1];
            int num = gem[a] >> 1;
            gem[a] -= num;
            gem[b] += num;
        }
        Arrays.sort(gem);
        return gem[n-1] - gem[0];
    }
}
