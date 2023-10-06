package com.leetcode._2023_9;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2136. 全部开花的最早一天
 *
 * @author DHW
 * @date 2023/9/30 11:32
 * @Version 1.0
*/
public class ProblemsNo2136 {

    @Test
    public void solution() {
        int[] plantTime = new int[]{1,4,3};
        int[] growTime = new int[]{2,3,1};
        System.out.println("res = " + earliestFullBloom(plantTime, growTime));
    }

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int len = growTime.length;
        Integer[] indices = new Integer[len];
        for (int i = 0; i < len; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (x,y) -> growTime[y] - growTime[x]);

        int res = 0;
        int t = 0;
        for (int i = 0; i < indices.length; i++) {
            t += plantTime[indices[i]];
            res = Math.max(res, t + growTime[indices[i]]);
        }
        return res;
    }
}
