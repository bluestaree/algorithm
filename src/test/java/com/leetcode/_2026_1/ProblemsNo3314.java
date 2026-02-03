package com.leetcode._2026_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ForkJoinPool;


/**
 * 3314. 构造最小位运算数组 I
 *
 * @author DHW
 * @date 2026/1/20 9: 05
 * @Version 1.0
*/
public class ProblemsNo3314 {

    @Test
    public void solution() {
        List<Integer> num = new ArrayList<>();
        num.add(2);
        num.add(13);
        num.add(31);
        System.out.println("res = " + minBitwiseArray(num));
    }

    public int[] minBitwiseArray(List<Integer> nums) {
        int size = nums.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            Integer x = nums.get(i);
            if(x == 2) {
                ans[i] = -1;
                continue;
            }
            for (int j = 1; j < 32; j++) {
                if((x >> j & 1) == 0) {
                    ans[i] = x ^ (1 << (j - 1));
                    break;
                }
            }

        }
        return ans;
    }
}

