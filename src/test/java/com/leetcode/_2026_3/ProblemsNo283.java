package com.leetcode._2026_3;

import org.junit.Test;
import sun.security.krb5.internal.tools.Klist;

import java.util.Arrays;


/**
 * 283. 移动零
 *
 * @author DHW
 * @date 2026/3/30 11: 20
 * @Version 1.0
 */
public class ProblemsNo283 {

    @Test
    public void solution() {
        int[] nums = new int[]{0,1,0,3,12};
    }

    public void moveZeroes(int[] nums) {
        int cur = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] != 0) {
                nums[cur++] = nums[i];
            }
        }
        for (int i = cur; i < n; i++) {
            nums[i] = 0;
        }
    }

}

