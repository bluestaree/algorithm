package com.leetcode._2025_12;

import org.junit.Test;


/**
 * 3. 无重复字符的最长子串
 *
 * @author DHW
 * @date 2025/12/12 10: 12
 * @Version 1.0
*/
public class ProblemsNo3 {

    @Test
    public void solution() {
        String s = "abcabcbb";
        System.out.println("res = " + lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int left = 0;
        int[] cnt = new int[128];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            cnt[c]++;
            while(cnt[c] > 1) {
                cnt[charArray[left]]--;
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}

