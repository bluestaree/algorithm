package com.leetcode._2024_4;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 1052. 爱生气的书店老板
 *
 * @author DHW
 * @date 2024/4/23 8:45
 * @Version 1.0
*/
public class ProblemsNo1052 {

    @Test
    public void solution() {
        int[] customers = new int[]{1,0,1,2,1,1,7,5};
        int[] grumpy = new int[]{0,1,0,1,0,1,0,1};
        int minutes = 3;
        System.out.println("res = " + maxSatisfied(customers, grumpy, minutes));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            if(grumpy[i] == 0) {
                maxNum += customers[i];
            }
        }
        int res = maxNum;
        for (int i = 0; i < n; i++) {
            if(grumpy[i] == 1) {
                int t = maxNum;
                for (int j = i ; j < i + minutes && j < n; j++) {
                    if(grumpy[j] == 1) {
                        t += customers[j];
                    }
                }
                res = Math.max(res, t);
            }
        }
        return res;
    }


}

