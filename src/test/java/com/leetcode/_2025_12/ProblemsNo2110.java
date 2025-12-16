package com.leetcode._2025_12;

import org.junit.Test;

import java.util.HashMap;


/**
 * 2110. 股票平滑下跌阶段的数目
 *
 * @author DHW
 * @date 2025/12/15 8: 46
 * @Version 1.0
*/
public class ProblemsNo2110 {

    @Test
    public void solution() {
        int[] prices =  new int[]{8,6,7,7};
        System.out.println("res = " + getDescentPeriods(prices));
    }

    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long ans = 0;
        int dec = 0;
        for (int i = 0; i < n; i++) {
            if(i > 0 && prices[i] == prices[i - 1] - 1) {
                dec++;
            } else {
                dec = 1;
            }
            ans += dec;
        }
        return ans;
    }

}

