package com.leetcode._2024_9;

import org.junit.Test;

import java.util.*;


/**
 * 997. 找到小镇的法官
 *
 * @author DHW
 * @date 2024/9/12 11:08
 * @Version 1.0
*/
public class ProblemsNo997 {

    @Test
    public void solution() {
        int[][] trust = new int[][]{new int[]{1,2}};
        int n = 2;
        System.out.println("res = " + findJudge(n, trust));
    }

    public int findJudge(int n, int[][] trust) {
        int[][] memo = new int[n+1][2];
        for (int i = 0; i < trust.length; i++) {
            memo[trust[i][0]][0]++;
            memo[trust[i][1]][1]++;
        }
        int target = n -1;
        for (int i = 1; i < memo.length; i++) {
            if(memo[i][0] == 0 &&  memo[i][1] == target) {
                return i;
            }
        }
        return -1;
    }
}

