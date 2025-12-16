package com.leetcode._2025_11;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 1930. 长度为 3 的不同回文子序列
 *
 * @author DHW
 * @date 2025/11/21 8: 44
 * @Version 1.0
*/
public class ProblemsNo1930 {

    @Test
    public void solution() {
        String s = "aabca";
        System.out.println("res = " + countPalindromicSubsequence(s));
    }


    public int countPalindromicSubsequence1(String s) {
        int ans = 0;
        for (char c = 'a'; c <= 'z'; ++c) {
            int l = s.indexOf(c), r = s.lastIndexOf(c);
            int mask = 0;
            for (int i = l + 1; i < r; ++i) {
                int j = s.charAt(i) - 'a';
                if ((mask >> j & 1) == 0) {
                    mask |= 1 << j;
                    ++ans;
                }
            }
        }
        return ans;
    }

    public int countPalindromicSubsequence(String s) {
        int[][] c = new int[26][2];
        Arrays.stream(c).forEach(a -> Arrays.fill(a, -1));
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - 'a';
            if(c[index][0] == -1) {
                c[index][0] = i;
            } else {
                c[index][1] = i;
            }
        }
        HashSet<String> set = new HashSet<>();
        for (int[] ints : c) {
            if(ints[0] == -1 || ints[1] == -1) {
                continue;
            }
            int a = ints[0];
            int b = ints[1];
            char[] chars = new char[3];
            chars[0] = s.charAt(a);
            chars[2] = s.charAt(b);
            for (int i = a + 1; i < b; i++) {
                chars[1] = s.charAt(i);
                set.add(new String(chars));
            }
        }
        return set.size();
    }
}

