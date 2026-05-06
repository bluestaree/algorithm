package com.leetcode._2026_4;

import org.junit.Test;


/**
 * 2515. 到目标字符串的最短距离
 *
 * @author DHW
 * @date 2026/4/15 8: 52
 * @Version 1.0
 */
public class ProblemsNo2515 {

    @Test
    public void solution() {
        String[] words = new String[]{"hello","i","am","leetcode","hello"};
        String target = "hello";
        int startIndex = 1;
        System.out.println("sortArrayByParity(nums) = " + closestTarget(words, target, startIndex));
    }

    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = n;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int d = Math.abs(i - startIndex);
                ans = Math.min(ans, Math.min(d, n - d));
            }
        }
        return ans == n ? -1 : ans;
    }

}

