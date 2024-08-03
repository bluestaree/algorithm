package com.leetcode._2024_8;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3143. 正方形中的最多点数
 *
 * @author DHW
 * @date 2024/8/3 10:56
 * @Version 1.0
*/
public class ProblemsNo3143 {

    @Test
    public void solution() {
        int[][] points = new int[][]{new int[]{2,2},new int[]{-1,-2},new int[]{-4,4},new int[]{-3,1},new int[]{3,-3}};
        String s = "abdca";
        System.out.println("res = " + maxPointsInsideSquare(points, s));
    }


    public int maxPointsInsideSquare(int[][] points, String s) {
        int n = s.length();
        int[] a = new int[26];
        int[] nums = new int[n];
        Arrays.fill(a, -1);
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = Math.max(Math.abs(points[i][0]) , Math.abs(points[i][1]));
            nums[i] = cur;
            int index = s.charAt(i) - 'a';
            if(a[index] == -1) {
                a[index] = cur;
            } else {
                max =Math.min(max, Math.max(cur, a[index]));
                a[index] = Math.min(cur, a[index]);
            }
        }
        int res = 0;
        for (int num : nums) {
            if(num < max) {
              res++;
            }
        }
        return res;
    }
}

