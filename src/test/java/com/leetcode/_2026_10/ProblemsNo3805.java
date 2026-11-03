package com.leetcode._2026_10;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;


/**
 * 3805. 统计凯撒加密对数目
 *
 * @author DHW
 * @date 2026/10/12 9:34
 * @Version 1.0
*/
public class ProblemsNo3805 {

    @Test
    public void solution() {
        String[] words = new String[]{"bbb","ccc"};
        System.out.println("res = " + countPairs(words));
    }

    public long countPairs(String[] words) {
        long ans = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            char[] charArray = word.toCharArray();
            char base = word.charAt(0);
            for (int i = 0; i < charArray.length; i++) {
                charArray[i] = (char) ((charArray[i] - base + 26) % 26);
            }
            word = new String(charArray);
            int c = map.getOrDefault(word, 0);
            ans += c;
            map.put(word, c + 1);
        }
        return ans;
    }

}
