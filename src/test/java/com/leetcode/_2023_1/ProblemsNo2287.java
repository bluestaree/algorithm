package com.leetcode._2023_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2287. 重排字符形成目标字符串
 *
 * @author DHW
 * @date 2023/1/13 16:16
 * @Version 1.0
*/
public class ProblemsNo2287 {

    @Test
    public void solution() {
        String s = "abcba";
        String target = "abc";
        System.out.println("res = " + rearrangeCharacters(s, target));
    }

    public int rearrangeCharacters(String s, String target) {
        int[] bucket = new int[26];
        char[] chars = target.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            bucket[chars[i] - 'a'] = bucket[chars[i] - 'a'] + 1;
        }

        int[] num = new int[26];
        char[] s1 = s.toCharArray();
        for (int i = 0; i < s1.length; i++) {
            num[s1[i] - 'a'] = num[s1[i] - 'a'] + 1;
        }

        int res = 0;
        while(true) {
            for (int i = 0; i < bucket.length; i++) {
                if(bucket[i] == 0) {
                    continue;
                }
                num[i] = num[i] - bucket[i];
                if(num[i] < 0) {
                   return res;
                }
            }
            res++;
        }
    }
}
