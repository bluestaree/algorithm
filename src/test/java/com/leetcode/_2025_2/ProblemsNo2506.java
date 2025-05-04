package com.leetcode._2025_2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * 2506. 统计相似字符串对的数目
 *
 * @author DHW
 * @date 2025/2/22 10: 45
 * @Version 1.0
*/
public class ProblemsNo2506 {

    @Test
    public void solution() {
        String[] words = new String[]{"abcdefg", "abc"};
        System.out.println("res = " + similarPairs(words));
    }

    public int similarPairs(String[] words) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int x = 0;
            for (char c : word.toCharArray()) {
                x |= 1 << (c - 'a');
            }
            res += map.merge(x, 1, Integer::sum) - 1;
        }
        return res;
    }
}

