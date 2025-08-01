package com.leetcode._2025_7;

import com.sun.org.apache.xerces.internal.xinclude.MultipleScopeNamespaceSupport;
import org.junit.Test;

import java.util.HashSet;


/**
 * 2419. 按位与最大的最长子数组
 *
 * @author DHW
 * @date 2025/7/30 9: 14
 * @Version 1.0
*/
public class ProblemsNo2419 {

    @Test
    public void solution() {
        int[] nums =  new int[]{2,5};
        System.out.println("res = " + longestSubarray(nums));
    }

    public int longestSubarray(int[] nums) {
        int mx = 0;
        int t = 0;
        int ans = 0;
        for (int num : nums) {
            if(num > mx) {
                mx = num;
                ans = 1;
                t = 1;
            }  else if(num == mx) {
                t++;
                ans = Math.max(ans, t);
            } else {
                t = 0;
            }
        }
        return ans;
    }

}

