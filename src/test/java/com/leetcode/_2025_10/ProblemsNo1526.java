package com.leetcode._2025_10;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1526. 形成目标数组的子数组最少增加次数
 *
 * @author DHW
 * @date 2025/10/28 8: 56
 * @Version 1.0
*/
public class ProblemsNo1526 {

    @Test
    public void solution() {
        int[] target =  new int[]{3,1,5,4,2};
        System.out.println("res = " + minNumberOperations(target));
    }

    public int minNumberOperations(int[] target) {
        int ans = 0, x = 0, n = target.length;
        for (int i = 0; i < n; i++) {
            if (x < target[i]) {
                ans += target[i] - x;
            }
            x = target[i];
        }

        return ans;

    }

}

