package com.leetcode._2022_10;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 *
 * @author DHW
 * @date 2022/10/11 10:59
 * @Version 1.0
*/
public class ProblemsNo1790 {

    @Test
    public void solution() {
        String s1 = "abcd";
        String s2 = "dcba";
        System.out.println("s2 = " + areAlmostEqual(s1, s2));
    }

    public boolean areAlmostEqual(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int diffIndex = -1;
        int num = 1;
        for (int i = 0; i < chars1.length; i++) {
            if(chars1[i] != chars2[i]) {
                if(num == 0) {
                    return false;
                }
                if(diffIndex == -1) {
                    diffIndex = i;
                    continue;
                }
                if(chars1[diffIndex] != chars2[i] || chars1[i] != chars2[diffIndex]) {
                    return false;
                }
                num--;
            }
        }
        if(diffIndex != -1 && num == 1) {
            return false;
        }
        return true;
    }
}
