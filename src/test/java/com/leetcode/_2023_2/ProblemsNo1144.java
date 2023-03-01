package com.leetcode._2023_2;

import org.junit.Test;


/**
 * 1144. 递减元素使数组呈锯齿状
 *
 * @author DHW
 * @date 2023/2/27 10:38
 * @Version 1.0
*/
public class ProblemsNo1144 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println("res = " + movesToMakeZigzag(nums));
    }

    public int movesToMakeZigzag(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int one = 0;
        int two = 0;
        for (int i = 1; i < nums.length; i+=2) {
            one = calculate(nums, one, i);
        }

        for (int i = 0; i < nums.length; i+=2) {
            two = calculate(nums, two, i);
        }
        return Math.min(one, two);
    }

    private int calculate(int[] nums, int count, int i) {
        int num = 0;
        if(i == 0) {
            num = nums[i+1];
        } else if(i == nums.length - 1) {
            num = nums[i-1];
        } else {
            num = Math.min(nums[i-1], nums[i+1]);
        }
        if(num > nums[i]) {
            return count;
        }
        int dis = nums[i] - num + 1;
        count += dis;
        return count;
    }
}
