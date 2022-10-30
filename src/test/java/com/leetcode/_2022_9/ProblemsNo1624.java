package com.leetcode._2022_9;

import org.junit.Test;

import java.util.*;


/**
 * 1624. 两个相同字符之间的最长子字符串
 *
 * @author DHW
 * @date 2022/9/17 12:32
 * @Version 1.0
*/
public class ProblemsNo1624 {

    @Test
    public void solution() {
        String s = "cabbac";
        System.out.println("maxInterval = " + maxLengthBetweenEqualCharacters(s));
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        if(s.length() == 1) {
            return -1;
        }
        HashMap<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])) {
                map.get(chars[i]).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                map.put(chars[i], indexList);
            }
        }

        int maxInterval = -1;
        for (Map.Entry<Character, List<Integer>> characterListEntry : map.entrySet()) {
            List<Integer> value = characterListEntry.getValue();
            int size = value.size();
            if(size <= 1) {
                continue;
            }
            int i = value.get(size - 1) - value.get(0) - 1;
            if(maxInterval<i) {
                maxInterval = i;
            }
        }
        return maxInterval;
    }
}
