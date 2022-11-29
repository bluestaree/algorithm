package com.leetcode._2022_11;

import org.junit.Test;


/**
 * 1668. 最大重复子字符串
 *
 * @author DHW
 * @date 2022/11/3 20:39
 * @Version 1.0
*/
public class ProblemsNo1668 {

    @Test
    public void solution() {
        String sequence = "aaaba aaaba aaba aaaba aaaba aaaba aaaba";
        String word = "aaaba";
        System.out.println("arr = " + maxRepeating(sequence, word));
    }

    public int maxRepeating(String sequence, String word) {
        if(sequence.length() < word.length()) {
            return 0;
        }
        char[] chars = sequence.toCharArray();
        char[] chars1 = word.toCharArray();

        int l = 0;
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars1[l] == chars[i]) {
                l++;
            } else {
                i=i-l;
                l=0;
            }
            if(l == chars1.length) {
                res++;
                l=0;
            }
        }
        return res;
    }

    public int maxRepeating1(String sequence, String word) {
        int count = 0;
        String temp = word;
        while (true) {
            if (sequence.contains(temp)) {
                count++;
                temp += word;
            } else {
                break;
            }
        }

        return count;
    }
}
