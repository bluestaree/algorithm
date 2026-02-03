package com.leetcode._2026_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1266. 访问所有点的最小时间
 *
 * @author DHW
 * @date 2026/1/12 8:37
 * @Version 1.0
*/
public class ProblemsNo1266 {

    @Test
    public void solution() {
        int[][] matrix = new int[3][3];
        int[] i1 = new int[]{1,1,1};
        int[] i2 = new int[]{1,0,1};
        int[] i3 = new int[]{1,1,1};
        matrix[0] = i1;
        matrix[1] = i2;
        matrix[2] = i3;

        System.out.println("i3 = " + minTimeToVisitAllPoints(matrix));
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        int[] cur = points[0];
        for (int i = 1; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            ans += Math.max(Math.abs(x - cur[0]), Math.abs(y - cur[1]));
            cur = points[i];
        }
        return ans;
    }
}
