package com.leetcode._2023_1;

import org.junit.Test;


/**
 * 1828. 统计一个圆中点的数目
 *
 * @author DHW
 * @date 2023/1/24 15:03
 * @Version 1.0
 */
public class ProblemsNo1828 {

    @Test
    public void solution() {
        int[][] points = new int[][]{new int[]{1,3}, new int[]{3,3}, new int[]{5,3}, new int[]{2, 2}};
        int[][] queries = new int[][]{new int[]{2,3,1}, new int[]{4,3,1}, new int[]{1,1,2}};
        System.out.println("res = " + countPoints(points, queries));
    }

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int centerX = queries[i][0];
            int centerY = queries[i][1];
            int len = queries[i][2];
            for (int j = 0; j < points.length; j++) {
                int pointX = points[j][0];
                int pointY = points[j][1];
                if ((centerX - pointX) * (centerX - pointX) + (centerY - pointY) * (centerY - pointY) <= len * len) {
                    ++res[i];
                }
//                if (dist(pointX, pointY, centerX, centerY) <= len) {
//                    count++;
//                } else {
//                    break;
//                }
            }
        }
        return res;
    }

    private double dist(int pointX, int pointY, int centerX, int centerY) {
        double s;
        double dx = Math.abs(centerX - pointX);
        double dy = Math.abs(centerY - pointY);
        s = Math.sqrt(dx * dx + dy * dy);
        return s;
    }
}
