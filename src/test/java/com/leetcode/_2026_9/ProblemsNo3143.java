package com.leetcode._2026_9;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * 3143. 正方形中的最多点数
 *
 * @author DHW
 * @date 2026/9/2 8:49
 * @Version 1.0
*/
public class ProblemsNo3143 {

    @Test
    public void solution() {
        String s = "abb";
        int[][] points = new int[][]{new int[]{1,1},new int[]{-2,-2},new int[]{-2,-2}};
        System.out.println("res = " + maxPointsInsideSquare(points, s));
    }

    int ans = 0;

    public int maxPointsInsideSquare(int[][] points, String s) {

        int left = 0;
        int right = 1_000_000_001;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(points, s, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(int[][] points, String s, int mid) {
        int[] v = new int[26];
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            if(Math.abs(points[i][0]) <= mid && Math.abs(points[i][1]) <= mid) {
                int j = s.charAt(i) - 'a';
                if(v[j] == 1) {
                    return false;
                }
                v[j]++;
                count++;
            }
        }
        ans = count;
        return true;
    }
}
