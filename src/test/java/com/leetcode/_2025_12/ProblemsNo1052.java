package com.leetcode._2025_12;

import org.junit.Test;

import java.util.HashMap;


/**
 * 1052. 爱生气的书店老板
 *
 * @author DHW
 * @date 2025/12/9 8: 55
 * @Version 1.0
*/
public class ProblemsNo1052 {

    @Test
    public void solution() {
        int[] customers =  new int[]{4,10,10};
        int[] grumpy =  new int[]{1,1,0};
        int minutes = 2;
        System.out.println("res = " + maxSatisfied(customers, grumpy, minutes));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        int[] s = new int[2];
        for (int i = 0; i < customers.length; i++) {
            s[grumpy[i]] += customers[i];
            int l = i - minutes + 1;
            if(l < 0) {
                continue;
            }
            ans = Math.max(ans, s[1]);

            if(grumpy[l] == 1) {
                s[1] -= customers[l];
            }
        }

        return ans + s[0];
    }
}

