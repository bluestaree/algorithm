package com.leetcode._2024_6;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 520. 检测大写字母
 *
 * @author DHW
 * @date 2024/6/23 10:56
 * @Version 1.0
*/
public class ProblemsNo520 {

    @Test
    public void solution() {
        String word = "Google";
        System.out.println("res = " + detectCapitalUse(word));
    }

    public boolean detectCapitalUse(String word) {
        int cnt = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                cnt++;
            }
        }
        return cnt == 0 || cnt == word.length() || cnt == 1 && Character.isUpperCase(word.charAt(0));
    }
}

