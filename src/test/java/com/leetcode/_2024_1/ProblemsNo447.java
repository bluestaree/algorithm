package com.leetcode._2024_1;

import org.junit.Test;

import java.util.HashMap;


/**
 * 447. 回旋镖的数量
 *
 * @author DHW
 * @date 2024/1/8 11:29
 * @Version 1.0
*/
public class ProblemsNo447 {

    @Test
    public void solution() {
        int[][] points = new int[][]{new int[]{0,0},new int[]{1,0},new int[]{2,0}};
        System.out.println("res = " + numberOfBoomerangs(points));
    }

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int[] p1 : points) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int[] p2 : points) {
                int d = (p1[0]-p2[0]) * (p1[0]-p2[0]) + (p1[1]-p2[1]) * (p1[1]-p2[1]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            for (Integer value : map.values()) {
                res += value * (value - 1);
            }
        }
        return res;
    }
}

