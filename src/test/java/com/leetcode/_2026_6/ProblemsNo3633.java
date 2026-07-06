package com.leetcode._2026_6;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3633. 最早完成陆地和水上游乐设施的时间 I
 *
 * @author DHW
 * @date 2026/6/2 8: 33
 * @Version 1.0
 */
public class ProblemsNo3633 {

    @Test
    public void solution() {
        int[] landStartTime = new int[]{5,1,3};
        int[] landDuration = new int[]{5,1,3};
        int[] waterStartTime = new int[]{5,1,3};
        int[] waterDuration = new int[]{5,1,3};
        System.out.println("= res = " + earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int s1 = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            s1 = Math.min(s1, landStartTime[i] + landDuration[i]);
        }
        int ans1 = Integer.MAX_VALUE;
        for (int i = 0; i < waterStartTime.length; i++) {
            ans1 = Math.min(ans1, Math.max(s1, waterStartTime[i]) + waterDuration[i]);
        }

        int s2 = Integer.MAX_VALUE;
        for (int i = 0; i < waterStartTime.length; i++) {
            s2 = Math.min(s2, waterStartTime[i] + waterDuration[i]);
        }
        int ans2 = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            ans2 = Math.min(ans2, Math.max(s2, landStartTime[i]) + landDuration[i]);
        }
        return Math.min(ans1, ans2);
    }

}

