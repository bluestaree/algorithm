package com.leetcode._2026_1;

import org.junit.Test;


/**
 * 2516. 每种字符至少取 K 个
 *
 * @author DHW
 * @date 2026/1/12 9: 05
 * @Version 1.0
*/
public class ProblemsNo2516 {

    @Test
    public void solution() {
        String s = "52233";
        int k = 2;
        System.out.println("res = " + takeCharacters(s, k));
    }

    public int takeCharacters(String s, int k) {
        int ans = 0;
        int n = s.length();
        if(n < 3 * k) {
            return -1;
        }
        char[] charArray = s.toCharArray();
        int[] count = new int[3];
        for (char c : charArray) {
            count[c - 'a']++;
        }
        if (count[0] < k || count[1] < k || count[2] < k) {
            return -1;
        }
        if (count[0] == k && count[1] == k && count[2] == k) {
            return n;
        }
        int left = 0;
        for (int r = 0; r < charArray.length; r++) {
            int i = charArray[r] - 'a';
            count[i]--;
            while (count[i] < k) {
                count[charArray[left] - 'a']++;
                left++;
            }
            ans = Math.max(ans, r - left + 1);
        }

        return n - ans;
    }
}

