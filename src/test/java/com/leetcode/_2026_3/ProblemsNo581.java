package com.leetcode._2026_3;

import org.junit.Test;

import java.util.PriorityQueue;


/**
 * 581. 最短无序连续子数组
 *
 * @author DHW
 * @date 2026/3/25 9: 22
 * @Version 1.0
*/
public class ProblemsNo581 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,3,3,2,4};
        System.out.println("res = " + findUnsortedSubarray(nums));
    }

    public int findUnsortedSubarray(int[] nums) {
        //初始化
        int len = nums.length;
        int min = nums[len-1];
        int max = nums[0];
        int begin = 0, end = -1;
        //遍历
        for(int i = 0; i < len; i++){
            if(nums[i] < max){      //从左到右维持最大值，寻找右边界end
                end = i;
            }else{
                max = nums[i];
            }

            if(nums[len-i-1] > min){    //从右到左维持最小值，寻找左边界begin
                begin = len-i-1;
            }else{
                min = nums[len-i-1];
            }
        }
        return end-begin+1;
    }
}

