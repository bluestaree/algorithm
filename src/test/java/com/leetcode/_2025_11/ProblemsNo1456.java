package com.leetcode._2025_11;

import org.junit.Test;


/**
 * 1456. 定长子串中元音的最大数目
 *
 * @author DHW
 * @date 2025/11/25 9: 15
 * @Version 1.0
*/
public class ProblemsNo1456 {

    @Test
    public void solution() {
        String s = "aabaa";
        int k = 5;
        System.out.println("res = " + maxVowels(s, k));
    }

    public int maxVowels(String s, int k) {
        int ans = 0;
        int value= 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == 'a' || charArray[i] == 'e' || charArray[i] == 'i' || charArray[i] == 'o' || charArray[i] == 'u') {
                value++;
            }
            int l = i - k + 1;
            if(l < 0) {
                continue;
            }
            ans = Math.max(ans, value);
            if(charArray[l] == 'a' || charArray[l] == 'e' || charArray[l] == 'i' || charArray[l] == 'o' || charArray[l] == 'u') {
                value--;
            }
        }
        return ans;
    }
}

