package com.leetcode._2022_12;

import org.junit.Test;

import javax.swing.plaf.metal.MetalIconFactory;


/**
 * 1785. 构成特定和需要添加的最少元素
 *
 * @author DHW
 * @date 2022/12/16 9:25
 * @Version 1.0
*/
public class ProblemsNo1785 {

    @Test
    public void solution() {
        int[] nums = new int[]{-1,0,1,1,1};
        int limit = 1;
        int goal = 771843707;
        System.out.println("res = " + minElements(nums, limit, goal));
    }

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        long len = Math.abs(sum - goal);
        return (int)((len + limit - 1) / limit);
    }
}
