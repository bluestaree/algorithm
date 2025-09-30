package com.leetcode._2025_9;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 3027. 人员站位的方案数 II
 *
 * @author DHW
 * @date 2025/9/3 8: 40
 * @Version 1.0
*/
public class ProblemsNo3027 {

    @Test
    public void solution() {
        int[][] points =  new int[][]{new int[]{2,4},new int[]{3,9},new int[]{4,5},new int[]{2,10}};
        System.out.println("res = " + numberOfPairs(points));
    }

    public int numberOfPairs(int[][] points) {
        int ans = 0;
        Arrays.sort(points, (a, b) -> {
            if(a[0] == b[0]) {
               return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        for (int i = 0; i < points.length; i++) {
            int maxY = Integer.MIN_VALUE;
            int y = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                if(y >= points[j][1] && points[j][1] > maxY){
                    ans++;
                    maxY = points[j][1];
                }
            }
        }
        return ans;
    }
}

