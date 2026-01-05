package com.leetcode._2026_1;

import org.junit.Test;

import java.util.HashMap;


/**
 * 1390. 四因数
 *
 * @author DHW
 * @date 2026/1/4 10: 22
 * @Version 1.0
*/
public class ProblemsNo1390 {

    @Test
    public void solution() {
        int[] nums =  new int[]{21,4,7};
        System.out.println("res = " + sumFourDivisors(nums));
    }

    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {

            int cnt = 0;
            int sum = 0;

            for (int j = 1; j * j <= nums[i]; j++) {
                if(nums[i] % j == 0) {
                    cnt++;
                    sum += j;
                    if(j * j != nums[i]) {
                        cnt++;
                        sum += nums[i] / i;
                    }
                }
            }

            if(cnt == 4) {
                ans += sum;
            }
        }

        return ans;
    }


}

