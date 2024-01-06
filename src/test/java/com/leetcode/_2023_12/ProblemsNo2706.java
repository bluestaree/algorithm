package com.leetcode._2023_12;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2706. 购买两块巧克力
 *
 * @author DHW
 * @date 2023/12/1 10:27
 * @Version 1.0
*/
public class ProblemsNo2706 {

    @Test
    public void solution() {
        int[] prices = new int[]{6,2,3,1,4,5};
        int money = 10;
        System.out.println("res = " + buyChoco(prices, money));
    }

    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int num = prices[0] + prices[1];
        return num > money ? money : money - num;
    }
}

