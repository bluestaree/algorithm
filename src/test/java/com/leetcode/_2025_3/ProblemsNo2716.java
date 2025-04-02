package com.leetcode._2025_3;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 2716. 最小化字符串长度
 *
 * @author DHW
 * @date 2025/3/28 9: 37
 * @Version 1.0
*/
public class ProblemsNo2716 {

    @Test
    public void solution() {
        String s = "aaabc";
        System.out.println("res = " + minimizedStringLength(s));
    }

    public int minimizedStringLength(String s) {
        Set<Character> ss = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            ss.add(s.charAt(i));
        }
        return ss.size();
    }
}

