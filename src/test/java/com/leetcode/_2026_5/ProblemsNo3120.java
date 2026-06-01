package com.leetcode._2026_5;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 3120. 统计特殊字母的数量 I
 *
 * @author DHW
 * @date 2026/5/26 8: 31
 * @Version 1.0
 */
public class ProblemsNo3120 {

    @Test
    public void solution() {
        String colors = "AAABABB";
        System.out.println("res = " + numberOfSpecialChars(colors));
    }

    public int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<Character>();
        int length = word.length();
        for (int i = 0; i < length; i++) {
            set.add(word.charAt(i));
        }
        int count = 0;
        for (char upper = 'A', lower = 'a'; upper <= 'Z'; upper++, lower++) {
            if (set.contains(upper) && set.contains(lower)) {
                count++;
            }
        }
        return count;
    }
}

