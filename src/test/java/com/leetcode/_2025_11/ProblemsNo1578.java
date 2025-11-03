package com.leetcode._2025_11;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;


/**
 * 1578. 使绳子变成彩色的最短时间
 *
 * @author DHW
 * @date 2025/11/3 8: 44
 * @Version 1.0
*/
public class ProblemsNo1578 {

    @Test
    public void solution() {
        String colors = "aabaa";
        int[] neededTime =  new int[]{1,2,3,4,1};
        System.out.println("res = " + minCost(colors, neededTime));
    }

    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        char[] charArray = colors.toCharArray();
        int mx = neededTime[0];
        int sum = neededTime[0];
        for (int i = 1; i < charArray.length; i++) {
            if(charArray[i] == charArray[i - 1]) {
                mx = Math.max(mx, neededTime[i]);
                sum += neededTime[i];
            } else {
                ans += sum - mx;
                mx = neededTime[i];
                sum = neededTime[i];
            }
        }
        ans += sum - mx;
        return ans;
    }
}

