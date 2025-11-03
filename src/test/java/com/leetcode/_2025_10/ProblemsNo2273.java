package com.leetcode._2025_10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 2273. 移除字母异位词后的结果数组
 *
 * @author DHW
 * @date 2025/10/13 8: 52
 * @Version 1.0
*/
public class ProblemsNo2273 {

    @Test
    public void solution() {
        String[] words = new String[]{"a","b","c","d","e"};
        System.out.println("res = " + removeAnagrams(words));
    }

    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            char[] charArray = words[i].toCharArray();
            Arrays.sort(charArray);
            s[i] = new String(charArray);
        }
        int cur = 0;
        int i = 1;
        while (i < n) {
            if(!s[i].equals(s[cur])) {
                ans.add(words[cur]);
                cur = i;
            }
            i++;
        }
        ans.add(words[cur]);
        return ans;
    }

}

