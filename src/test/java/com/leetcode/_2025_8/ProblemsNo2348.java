package com.leetcode._2025_8;

import org.junit.Test;


/**
 * 2348. 全 0 子数组的数目
 *
 * @author DHW
 * @date 2025/8/19 10: 52
 * @Version 1.0
*/
public class ProblemsNo2348 {

    @Test
    public void solution() {
        int[] nums =  new int[]{3,3,3,1,2,1,1,2,3,3,4};
        System.out.println("res = " + zeroFilledSubarray(nums));
    }

    public long zeroFilledSubarray(int[] nums) {
        long ans = 0l;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                continue;
            }
            long num = 0;
            int t = 0;
            for (; i < nums.length && nums[i] == 0; i++) {
                t++;
                num += t;
            }
            ans += num;
        }
        return ans;
    }

}

