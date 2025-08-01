package com.leetcode._2025_7;

import cn.hutool.core.date.format.FastDatePrinter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.PriorityQueue;


/**
 * 3439. 重新安排会议得到最多空余时间 I
 *
 * @author DHW
 * @date 2025/7/9 10: 26
 * @Version 1.0
*/
public class ProblemsNo3439 {

    @Test
    public void solution() {
        int eventTime = 5;
        int k = 1;
        int[] startTime = new int[]{1,3};
        int[] endTime =  new int[]{2,5};
        System.out.println("res = " + maxFreeTime(eventTime, k, startTime, endTime));
    }

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int res = 0;
        int n = startTime.length;
        int[] nums = new int[n + 1];
        nums[0] = startTime[0] - 0;
        for (int i = 1; i < n; i++) {
            nums[i] = startTime[i] - endTime[i - 1];
        }
        nums[n] = eventTime - endTime[n - 1];

        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            if(i >= k) {
                res = Math.max(res, s);
                s -= nums[i - k];
            }
        }
        return res;
    }
}

