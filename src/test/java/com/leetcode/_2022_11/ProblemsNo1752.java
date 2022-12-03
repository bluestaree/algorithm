package com.leetcode._2022_11;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1752. 检查数组是否经排序和轮转得到
 *
 * @author DHW
 * @date 2022/11/27 14:09
 * @Version 1.0
*/
public class ProblemsNo1752 {

    @Test
    public void solution() {
        int[] nums = new int[]{3,4,5,1,2};
        System.out.println("arr = " + check(nums));
    }

    public boolean check(int[] nums) {
        int[] origin = nums.clone();
        boolean res = false;
        Arrays.sort(origin);
        for (int i = 0; i < nums.length; i++) {
            if(!res && origin[0] == nums[((0+i) % nums.length)]) {
                res = true;
                for (int j = 1; j < nums.length; j++) {
                    if(origin[j] != nums[((j+i) % nums.length)]) {
                        res = false;
                        break;
                    }
                }

            }
        }
        return res;
    }
}
