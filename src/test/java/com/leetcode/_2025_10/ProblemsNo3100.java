package com.leetcode._2025_10;

import org.junit.Test;


/**
 * 3100. 换水问题 II
 *
 * @author DHW
 * @date 2025/10/2 10: 36
 * @Version 1.0
*/
public class ProblemsNo3100 {

    @Test
    public void solution() {
        int numBottles = 10;
        int numExchange = 3;
        System.out.println("res = " + maxBottlesDrunk(numBottles, numExchange));
    }

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = 0;
        int empty = 0;
        while (numBottles > 0) {
            ans += numBottles;
            empty += numBottles;
            numBottles = 0;
            while(empty >= numExchange) {
                empty -= numExchange;
                numExchange++;
                numBottles++;
            }
        }
        return ans;
    }
}

