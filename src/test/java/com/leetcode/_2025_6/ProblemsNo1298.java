package com.leetcode._2025_6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


/**
 * 1298. 你能从盒子里获得的最大糖果数
 *
 * @author DHW
 * @date 2025/6/3 9: 38
 * @Version 1.0
*/
public class ProblemsNo1298 {

    @Test
    public void solution() {
        int[][] keys = new int[][]{new int[]{},new int[]{},new int[]{1},new int[]{}};
        int[][] containedBoxes = new int[][]{new int[]{1,2},new int[]{3},new int[]{},new int[]{}};
        int[] status = new int[]{1,0,1,0};
        int[] candies = new int[]{7,5,4,100};
        int[] initialBoxes = new int[]{};
        System.out.println("res = " + maxCandies(status, candies, keys, containedBoxes, initialBoxes));
    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int res = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n = status.length;
        int[] b = new int[n];
        int[] k = new int[n];
        boolean[] v = new boolean[n];
        for (int box : initialBoxes) {
            if(status[box] == 1) {
                v[box] = true;
                queue.offer(box);
            } else {
                b[box] = 1;
            }
        }

        while(!queue.isEmpty()) {
            Integer box = queue.poll();
            res += candies[box];
            for (int boxIndex : keys[box]) {
                if(b[boxIndex] == 1 && !v[boxIndex]) {
                    v[boxIndex] = true;
                    queue.offer(boxIndex);
                } else {
                    k[boxIndex] = 1;
                }
            }
            for (int boxIndex : containedBoxes[box]) {
                if(!v[boxIndex] && (status[boxIndex] == 1 || k[boxIndex] == 1)) {
                    v[boxIndex] = true;
                    queue.offer(boxIndex);
                } else {
                    b[boxIndex] = 1;
                }
            }
        }
        return res;
    }
}

