package com.leetcode._2025_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 3330. 找到初始输入字符串 I
 *
 * @author DHW
 * @date 2025/7/1 9: 55
 * @Version 1.0
*/
public class ProblemsNo3330 {

    @Test
    public void solution() {
        String word = "abbcccc";
        System.out.println("res = " + possibleStringCount(word));
    }

    public int possibleStringCount(String word) {
        int f = 1;
        for (int i = 1; i < word.length(); ++i) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                ++f;
            }
        }
        return f;
    }
}

