package com.leetcode._2024_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 3111. 覆盖所有点的最少矩形数目
 *
 * @author DHW
 * @date 2024/7/31 9:33
 * @Version 1.0
*/
public class ProblemsNo3111 {

    @Test
    public void solution() {
        int[][] points = new int[][]{new int[]{2,1},new int[]{1,0},new int[]{0,3}};
        int w = 1;
        System.out.println("res = " + minRectanglesToCoverPoints(points, w));
    }

    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a,b) -> a[0] - b[0]);
        int res = 1;
        int s = points[0][0];
        for (int i = 1; i < points.length; i++) {
            int len = points[i][0] - s;
            if(len > w) {
               res++;
               s = points[i][0];
            }
        }
        return res;
    }
}

