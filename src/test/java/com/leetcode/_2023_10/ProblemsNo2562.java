package com.leetcode._2023_10;

import org.junit.Test;


/**
 * 2562. 找出数组的串联值
 *
 * @author DHW
 * @date 2023/10/12 9:19
 * @Version 1.0
*/
public class ProblemsNo2562 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,2,3,1};
        System.out.println("res = " + findTheArrayConcVal(nums));
    }

    public long findTheArrayConcVal(int[] nums) {
        long res = 0;
        int left = 0;
        int right = nums.length - 1;
        StringBuilder sb = new StringBuilder();
        while(left < right) {
            sb.append(nums[left]);
            sb.append(nums[right]);
            res += Long.parseLong(sb.toString());
            sb.delete(0, sb.length());
            left++;
            right--;
        }
        if(left == right) {
            res += nums[left];
        }
        return res;
    }
}

