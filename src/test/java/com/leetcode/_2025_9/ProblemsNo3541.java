package com.leetcode._2025_9;

import org.junit.Test;


/**
 * 3541. 找到频率最高的元音和辅音
 *
 * @author DHW
 * @date 2025/9/7 10: 33
 * @Version 1.0
*/
public class ProblemsNo3541 {

    @Test
    public void solution() {
        String s = "successes";
        System.out.println("res = " + maxFreqSum(s));
    }

    public int maxFreqSum(String s) {
        int maxA = 0, maxB = 0;
        int[] freq = new int[26];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            freq[c - 'a']++;
            if(c == 'a' || c ==  'e' || c == 'i' || c == 'o' || c == 'u') {
                maxA = Math.max(maxA, freq[c - 'a']);
            } else {
                maxB = Math.max(maxB, freq[c - 'a']);
            }
        }
        return maxA + maxB;
    }
}

