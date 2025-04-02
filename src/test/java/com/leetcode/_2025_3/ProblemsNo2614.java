package com.leetcode._2025_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 2614. 对角线上的质数
 *
 * @author DHW
 * @date 2025/3/18 11: 02
 * @Version 1.0
*/
public class ProblemsNo2614 {

    @Test
    public void solution() {
        int[][] nums = new int[][]{new int[]{1,2,3},new int[]{5,6,7},new int[]{9,10,11}};
        System.out.println("res = " + diagonalPrime(nums));
    }

    public int diagonalPrime(int[][] nums) {
        int res = 0 ;
        int n = nums.length;

        for (int i = 0, j = n - 1; i < n && j >= 0; j--,i++) {
            res = Math.max(res, checkNum(nums[i][i]));
            if(i != j) {
                res = Math.max(res, checkNum(nums[i][j]));
            }
        }
        return res;
    }

    private int checkNum(int num) {
        if (num < 2) {
            return 0;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return 0;
            }
        }
        return num;
    }
}

