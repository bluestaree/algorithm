package com.leetcode._2023_6;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 1170. 比较字符串最小字母出现频次
 *
 * @author DHW
 * @date 2023/6/10 12:50
 * @Version 1.0
*/
public class ProblemsNo1170 {

    @Test
    public void solution() {
        String[] queries = new String[]{"bbb","cc"};
        String[] words = new String[]{"a","aa","aaa","aaaa"};
        System.out.println("res = " + numSmallerByFrequency(queries, words));
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];

        int queriesCount[] = new int[queries.length];
        int wordsCount[] = new int[words.length];
        count(queries, queriesCount);
        count(words, wordsCount);

        for (int i = 0; i < queriesCount.length; i++) {
            for (int j = 0; j < wordsCount.length; j++) {
                if(wordsCount[j] > queriesCount[i]) {
                    res[i]++;
                }
            }
        }
        return res;
    }

    private void count(String[] words, int[] counts) {
        for (int i = 0; i < words.length; i++) {
            String query = words[i];
            char[] chars = query.toCharArray();
            Arrays.sort(chars);
            int count = 1;
            for (int j = 1; j < chars.length; j++) {
                if (chars[j] != chars[j - 1]) {
                    break;
                }
                count++;
            }
            counts[i] = count;
        }
    }
}
