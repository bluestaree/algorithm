package com.leetcode._2025_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;


/**
 * 3000. 对角线最长的矩形的面积
 *
 * @author DHW
 * @date 2025/8/26 9: 17
 * @Version 1.0
*/
public class ProblemsNo3000 {

    @Test
    public void solution() {
        int[][] dimensions =  new int[][]{new int[]{9,3}, new int[]{6,8}};
        System.out.println("res = " + areaOfMaxDiagonal(dimensions));
    }

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxLen = 0;
        int ans = 0;
        for (int[] dimension : dimensions) {
            int len = dimension[0] * dimension[0] + dimension[1] * dimension[1];
            if(len > maxLen) {
                ans = dimension[0] * dimension[1];
                maxLen = len;
            } else if(len == maxLen) {
                ans = Math.max(ans, dimension[0] * dimension[1]);
            }
        }
        return ans;
    }
}

