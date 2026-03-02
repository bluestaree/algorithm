package com.leetcode._2026_2;

import org.junit.Test;


/**
 * 917. 仅仅反转字母
 *
 * @author DHW
 * @date 2026/2/28 10: 07
 * @Version 1.0
*/
public class ProblemsNo917 {

    @Test
    public void solution() {
        String s = "cat and mice";
        System.out.println("res = " + reverseOnlyLetters(s));
    }

    public String reverseOnlyLetters(String s) {
        char[] charArray = s.toCharArray();
        int l = 0, r = charArray.length - 1;
        while (l < r) {
            while (l < r && !Character.isLetter(charArray[l])) {
                l++;
            }
            while (l < r && !Character.isLetter(charArray[r])) {
                r--;
            }
            if (l < r) {
                char temp = charArray[l];
                charArray[l] = charArray[r];
                charArray[r] = temp;
                l++;
                r--;
            }
        }
        return new String(charArray);
    }
}

