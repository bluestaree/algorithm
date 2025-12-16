package com.leetcode._2025_11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 1018. 可被 5 整除的二进制前缀
 *
 * @author DHW
 * @date 2025/11/24 8: 40
 * @Version 1.0
*/
public class ProblemsNo1018 {

    @Test
    public void solution() {
        int[] nums =  new int[]{1,1,1};
        System.out.println("res = " + prefixesDivBy5(nums));
    }

    public List<Boolean> prefixesDivBy5(int[] nums) {
        int m = 0;
        ArrayList<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            m = ((m << 1) + nums[i]) % 5;
            ans.add(m % 5 == 0);
        }
        return ans;
    }
}

