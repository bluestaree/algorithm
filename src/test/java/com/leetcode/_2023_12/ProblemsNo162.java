package com.leetcode._2023_12;

import org.junit.Test;


/**
 * 162. 寻找峰值
 *
 * @author DHW
 * @date 2023/12/18 12:35
 * @Version 1.0
*/
public class ProblemsNo162 {

    @Test
    public void solution() {
        int[] nums = new int[]{6,2,3,1,4,5};
        System.out.println("res = " + findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) >> 1;
            if(nums[mid] > nums[mid+1]) {
                right = mid;
            } else {
                left = mid + 1;
        }
        }
        return left;
    }
}

