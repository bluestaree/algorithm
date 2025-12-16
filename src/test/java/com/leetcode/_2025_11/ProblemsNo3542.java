package com.leetcode._2025_11;

import org.junit.Test;

import java.util.*;


/**
 * 3542. 将所有元素变为 0 的最少操作次数
 *
 * @author DHW
 * @date 2025/11/10 8: 43
 * @Version 1.0
*/
public class ProblemsNo3542 {

    @Test
    public void solution() {
        int[] nums =  new int[]{3,1,2,1};
        System.out.println("res = " + minOperations(nums));
    }

    public int minOperations(int[] nums) {
        Deque<Integer> stk = new ArrayDeque<>();
        int ans = 0;
        for (int x : nums) {
            while (!stk.isEmpty() && stk.peek() > x) {
                ans++;
                stk.pop();
            }
            if (x != 0 && (stk.isEmpty() || stk.peek() != x)) {
                stk.push(x);
            }
        }
        ans += stk.size();
        return ans;
    }

}

