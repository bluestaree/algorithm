package com.leetcode._2022_9;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 *
 * @author DHW
 * @date 2022/9/22 10:30
 * @Version 1.0
*/
public class ProblemsNo3 {

    @Test
    public void solution() {
        String s = "pwwkew";
        System.out.println("s = " + lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int count = 0;
        int startIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])){
                max = Math.max(max, count);
                Integer integer = map.get(chars[i]);
                for (int j = startIndex; j <= integer; j++) {
                    map.remove(chars[j]);
                    count--;
                }
                startIndex = integer + 1;
            }
            map.put(chars[i], i);
            count++;
        }
        return Math.max(max, count);
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }
}
