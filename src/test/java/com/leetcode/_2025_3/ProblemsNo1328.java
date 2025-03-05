package com.leetcode._2025_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 1328. 破坏回文串
 *
 * @author DHW
 * @date 2025/3/5 9: 40
 * @Version 1.0
*/
public class ProblemsNo1328 {

    @Test
    public void solution() {
        String palindrome = "d232";
        System.out.println("res = " + breakPalindrome(palindrome));
    }

    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n == 1) return "";

        char[] charArray = palindrome.toCharArray();


        for(int i = 0; i < n / 2; i++){
            if(charArray[i] != 'a') {
                charArray[i] = 'a';
                return new String(charArray);
            }
        }

        charArray[n - 1] = 'b';
        return new String(charArray);
    }
}

