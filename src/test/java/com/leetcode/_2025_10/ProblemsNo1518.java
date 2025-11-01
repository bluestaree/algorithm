package com.leetcode._2025_10;

import org.junit.Test;

import java.util.PriorityQueue;


/**
 * 1518. 换水问题
 *
 * @author DHW
 * @date 2025/10/1 10: 36
 * @Version 1.0
*/
public class ProblemsNo1518 {

    @Test
    public void solution() {
        int numBottles = 4;
        int numExchange = 2;
        System.out.println("res = " + numWaterBottles(numBottles, numExchange));
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        while (numBottles >= numExchange) {
            ans += numExchange;
            numBottles -= numExchange - 1;
        }
        return ans + numBottles;
    }
}

