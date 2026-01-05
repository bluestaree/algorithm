package com.leetcode._2025_12;

import org.junit.Test;


/**
 * 2483. 商店的最少代价
 *
 * @author DHW
 * @date 2025/12/26 8: 58
 * @Version 1.0
*/
public class ProblemsNo2483 {

    @Test
    public void solution() {
        String customers = "YYYY";
        System.out.println("res = " + bestClosingTime(customers));
    }

    public int bestClosingTime(String customers) {
        int n = customers.length();
        int ans = 0, cost = 0;
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                cost++;
            }
        }
        int mn = cost;
        for (int j = 1; j <= n; j++) {
            cost += customers.charAt(j - 1) == 'N' ? 1 : -1;
            if (cost < mn) {
                ans = j;
                mn = cost;
            }
        }
        return ans;
    }
}

