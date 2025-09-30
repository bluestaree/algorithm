package com.leetcode._2025_9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


/**
 * 120. 三角形最小路径和
 *
 * @author DHW
 * @date 2025/9/25 9: 14
 * @Version 1.0
*/
public class ProblemsNo120 {

    @Test
    public void solution() {
        List<List<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(0);
        triangle.add(list1);
        System.out.println("res = " + minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n+1][n+1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = Math.min(f[i+1][j], f[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return f[0][0];
    }
}

