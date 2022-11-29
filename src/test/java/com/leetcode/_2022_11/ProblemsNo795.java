package com.leetcode._2022_11;

import org.junit.Test;


/**
 * 795. 区间子数组个数
 *
 * @author DHW
 * @date 2022/11/24 14:55
 * @Version 1.0
*/
public class ProblemsNo795 {

    @Test
    public void solution() {
        int[] nums = new int[]{73,55,36,5,55,14,9,7,72,52};
        int left = 32;
        int right = 69;
        System.out.println("res = " + numSubarrayBoundedMax(nums, left, right));
    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num >= left && num <= right) {
                count++;
                for (int j = i+1; j < nums.length; j++) {
                    int nextNum = nums[j];
                    if(nextNum <= right) {
                        count++;
                    }else {
                        break;
                    }
                }
            }
            if(num < left) {
                for (int j = i+1; j < nums.length; j++) {
                    int nextNum = nums[j];
                    if(nextNum > right) {
                        break;
                    }
                    if(!flag && nextNum >= left && nextNum <= right) {
                        flag = true;
                    }
                    if(flag) {
                        count++;
                    }
                }
                flag = false;
            }
        }
        return count;
    }
}
