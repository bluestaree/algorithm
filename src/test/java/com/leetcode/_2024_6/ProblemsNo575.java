package com.leetcode._2024_6;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 575. 分糖果
 *
 * @author DHW
 * @date 2024/6/2 11:27
 * @Version 1.0
*/
public class ProblemsNo575 {

    @Test
    public void solution() {
        int[] candyType = new int[]{1,1,2,2,3,3};
        System.out.println("res = " + distributeCandies(candyType));
    }

    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int t : candyType) {
            set.add(t);
        }
        return Math.min(set.size(), candyType.length / 2);
    }
}

