package com.leetcode._2023_6;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/**
 * 2559. 统计范围内的元音字符串数
 *
 * @author DHW
 * @date 2023/6/2 9:17
 * @Version 1.0
*/
public class ProblemsNo2559 {

    @Test
    public void solution() {
        String[] words = new String[]{"aba","bcb","ece","aa","e"};
        int[][] queries = new int[][]{new int[]{0,2}, new int[]{1,4}, new int[]{1,1}};
        System.out.println("res = " + vowelStrings(words, queries));
    }

    public int[] vowelStrings(String[] words, int[][] queries) {

        Character[] c = new Character[]{'a', 'e', 'i', 'o', 'u'};
        int[] target = new int[26];

        for (int i = 0; i < c.length; i++) {
            target[c[i] - 'a'] = 1;
        }
        int[] sums = new int[words.length+1];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] chars = word.toCharArray();
            int i1 = target[chars[0] - 'a'];
            int i2 = target[chars[chars.length - 1] - 'a'];
            sums[i+1] = sums[i] + (i1 == 1 && i2 == 1? 1 : 0);
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            res[i] = sums[query[1]+1] - sums[query[0]];
        }
        return res;
    }
}
