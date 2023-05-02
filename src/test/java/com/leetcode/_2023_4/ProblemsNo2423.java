package com.leetcode._2023_4;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 2423. 删除字符使频率相同
 *
 * @author DHW
 * @date 2023/4/29 11:08
 * @Version 1.0
*/
public class ProblemsNo2423 {

    @Test
    public void solution() {
        String word = "ddaccb";
        System.out.println("res = " + equalFrequency(word));
    }

    public boolean equalFrequency(String word) {
        int[] charCount = new int[26];
        int n = word.length();
        for (int i = 0; i < n; i++) {
            charCount[word.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (charCount[i] == 0) {
                continue;
            }
            charCount[i]--;
            HashSet<Integer> frequency = new HashSet<Integer>();
            for (int f : charCount) {
                if (f > 0) {
                    frequency.add(f);
                }
            }
            if (frequency.size() == 1) {
                return true;
            }
            charCount[i]++;
        }
        return false;
    }
}
