package com.leetcode._2023_11;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 1657. 确定两个字符串是否接近
 *
 * @author DHW
 * @date 2023/11/30 9:53
 * @Version 1.0
*/
public class ProblemsNo1657 {

    @Test
    public void solution() {
        String word1 = "abc";
        String word2 = "bca";
        System.out.println("res = " + closeStrings(word1, word2));
    }
    public boolean closeStrings(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (int i = 0; i < chars1.length; i++) {
            c1[chars1[i] - 'a']++;
        }

        for (int i = 0; i < chars2.length; i++) {
            c2[chars2[i] - 'a']++;
        }

        for (int i = 0; i < c1.length; i++) {
            if((c1[i] == 0) != (c2[i] == 0) ) {
                return false;
            }
        }

        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if(c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}

