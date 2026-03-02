package com.leetcode._2026_2;

import org.junit.Test;


/**
 * 2000. 反转单词前缀
 *
 * @author DHW
 * @date 2026/2/9 13: 54
 * @Version 1.0
*/
public class ProblemsNo2000 {

    @Test
    public void solution() {
        String s = "QWER";
        char ch = 'E';
        System.out.println("res = " + reversePrefix(s, ch));
    }

    public String reversePrefix(String word, char ch) {
        char[] chars = word.toCharArray();
        int left = 0;
        int right = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ch) {
                right = i;
                break;
            }
        }
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}

