package com.leetcode._2026_10;

import org.junit.Test;

import java.util.HashMap;


/**
 * 2506. 统计相似字符串对的数目
 *
 * @author DHW
 * @date 2026/10/20 9:34
 * @Version 1.0
*/
public class ProblemsNo2506 {

    @Test
    public void solution() {
        String[] words = new String[]{"bbb","ccc"};
        System.out.println("res = " + similarPairs(words));
    }

    public int similarPairs(String[] words) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            Integer count = map.getOrDefault(mask, 0);
            ans += count;
            map.put(mask, count + 1);
        }
        return ans;
    }

}
