package com.leetcode._2024_6;

import org.junit.Test;

import java.util.PriorityQueue;


/**
 * 1103. 分糖果 II
 *
 * @author DHW
 * @date 2024/6/3 9:40
 * @Version 1.0
*/
public class ProblemsNo1103 {

    @Test
    public void solution() {
        int num_people = 3;
        int candies = 4;
        System.out.println("res = " + distributeCandies(candies, num_people));
    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        for (int i = 1; candies > 0; i++) {
            res[(i - 1) % num_people] += Math.min(i, candies);
            candies -= i;
        }
        return res;
    }
}

