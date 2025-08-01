package com.leetcode._2025_7;

import org.junit.Test;

import static cn.hutool.poi.excel.sax.ElementName.f;


/**
 * 3201. 找出有效子序列的最大长度 I
 *
 * @author DHW
 * @date 2025/7/16 8: 52
 * @Version 1.0
*/
public class ProblemsNo3201 {

    @Test
    public void solution() {
        int[] nums =  new int[]{2,5};
        System.out.println("res = " + maximumLength(nums));
    }

    public int maximumLength(int[] nums) {
        int n = nums.length;
        int even = 0, odd = 0, t = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            if ( i != n - 1 && nums[i] % 2 != nums[i + 1] % 2) {
                t++;
            }
        }
        return Math.max(Math.max(even, odd), t + 1) ;
    }

}

