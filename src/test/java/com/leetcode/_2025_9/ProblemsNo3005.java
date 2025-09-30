package com.leetcode._2025_9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 3005. 最大频率元素计数
 *
 * @author DHW
 * @date 2025/9/22 9: 30
 * @Version 1.0
*/
public class ProblemsNo3005 {

    @Test
    public void solution() {
        int[] nums =  new int[]{3,3,3,1,2,1,1,2,3,3,4};
        System.out.println("res = " + maxFrequencyElements(nums));
    }

    public int maxFrequencyElements(int[] nums) {
        int[] a = new int[101];
        int max = 0;
        for (int num : nums) {
            a[num]++;
            max = Math.max(max, a[num]);
        }
        int ans = 0;
        for (int num : a) {
            if(num == max){
                ans += num;
            }
        }
        return ans;
    }

}

