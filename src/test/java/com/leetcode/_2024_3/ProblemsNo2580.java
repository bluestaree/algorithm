package com.leetcode._2024_3;

import org.junit.Test;

import java.util.*;


/**
 * 2580. 统计将重叠区间合并成组的方案数
 *
 * @author DHW
 * @date 2024/3/27 9:44
 * @Version 1.0
*/
public class ProblemsNo2580 {

    @Test
    public void solution() {
        int[][] ranges = new int[][]{new int[]{12,16}, new int[]{11,48}};
        System.out.println("res = " + countWays(ranges));
    }

    public int countWays(int[][] ranges) {
        int mod = 1000000007;
        int res = 1;
        int pre = -1;
        Arrays.sort(ranges, (x,y) -> x[0] - y[0]);
        for (int[] range : ranges) {
            if(pre < range[0]) {
                res = res * 2 % mod;
            }
            pre = Math.max(pre, range[1]);
        }
        return res;
    }

}

