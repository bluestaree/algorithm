package com.leetcode._2026_6;

import org.junit.Test;


/**
 * 1839. 所有元音按顺序排布的最长子字符串
 *
 * @author DHW
 * @date 2026/6/1 9: 20
 * @Version 1.0
 */
public class ProblemsNo1839 {

    @Test
    public void solution() {
        String word = "dcacccaa";
        System.out.println("res = " + longestBeautifulSubstring(word));
    }

    public int longestBeautifulSubstring(String word) {
        int ans = 0;
        int n = word.length();
        for(int i = 0; i < n;){
            int j = i + 1, type = 1;
            for(; j < n && word.charAt(j-1) <= word.charAt(j); j++){
                if(word.charAt(j-1) != word.charAt(j)) type++;
            }
            if(type == 5) {
                ans = Math.max(ans,j - i);
            }
            i = j;
        }
        return ans;
    }
}

