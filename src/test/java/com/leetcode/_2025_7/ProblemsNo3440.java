package com.leetcode._2025_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/**
 * 3440. 重新安排会议得到最多空余时间 II
 *
 * @author DHW
 * @date 2025/7/10 9: 44
 * @Version 1.0
*/
public class ProblemsNo3440 {

    @Test
    public void solution() {
        int eventTime = 5;
        int[] startTime = new int[]{1,3};
        int[] endTime =  new int[]{2,5};
        System.out.println("res = " + maxFreeTime(eventTime, startTime, endTime));
    }

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int res = 0;
        int n = startTime.length;
        int[] nums = new int[n + 1];
        nums[0] = startTime[0] - 0;
        for (int i = 1; i < n; i++) {
            nums[i] = startTime[i] - endTime[i - 1];
        }
        nums[n] = eventTime - endTime[n - 1];

        int[] rm = new int[n + 1];
        int cur = 0;
        for(int i = n;i >= 0;i--){
            if(cur < nums[i]) {
                cur = nums[i];
            }
            rm[i] = cur;
        }

        int lm = 0;
        for (int i = 0; i < n; i++) {
            if(i > 0 && lm < nums[i - 1]) {
                lm = nums[i - 1];
            }
            int num = nums[i] + nums[i+1];
            int temp = endTime[i] - startTime[i];
            int rmt = 0;
            if(i < n-1) {
                rmt = rm[i+2];
            }
            if(Math.max(lm, rmt) >= temp) {
                num += temp;
            }
            res = Math.max(res, num);
        }
        return res;
    }
}

