package com.leetcode._2024_5;

import org.junit.Test;


/**
 * 2960. 统计已测试设备
 *
 * @author DHW
 * @date 2024/5/10 8:57
 * @Version 1.0
*/
public class ProblemsNo2960 {

    @Test
    public void solution() {
        int[] batteryPercentages = new int[]{1,1,2,1,3};
        System.out.println("res = " + countTestedDevices(batteryPercentages));
    }

    public int countTestedDevices(int[] batteryPercentages) {
        int res = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if(batteryPercentages[i] - res > 0) {
                res++;
            }
        }
        return res;
    }
}

