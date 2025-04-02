package com.leetcode._2025_3;

import org.junit.Test;


/**
 * 3305. 元音辅音字符串计数 I
 *
 * @author DHW
 * @date 2025/3/12 8: 43
 * @Version 1.0
*/
public class ProblemsNo3305 {

    @Test
    public void solution() {
        String word = "ieaouqqieaouqq";
        int k = 1;
        System.out.println("res = " + countOfSubstrings(word, k));
    }

    int k;
    public int countOfSubstrings(String word, int k) {
        this.k = k;
        int left = 0;
        int right = 5 + k;
        int n = word.length();
        if(n < right) {
            return 0;
        }
        int res = 0;
        int[] counts = new int[6];
        while(left <= n - 5 - k) {
            if(left > 0) {
                counts[getIndex(word.charAt(left - 1))]--;
                counts[getIndex(word.charAt(right - 1))]++;
            } else {
                for (int i = left; i < right; i++) {
                    counts[getIndex(word.charAt(i))]++;
                }
            }
            int tag = checkValues(counts);
            if(tag >= 1) {
                int start = right;
                if(tag == 2) {
                    res++;
                }
                int end;
                for (end = start; end < n; end++) {
                    counts[getIndex(word.charAt(end))]++;
                    tag = checkValues(counts);
                    if(tag == 2) {
                        res++;
                    } else if(tag == 0) {
                        break;
                    }
                }
                for (int i = start; i <= end && i < n ; i++) {
                    counts[getIndex(word.charAt(i))]--;
                }
            }
            left++;
            right++;
        }
        return res;
    }

    private int checkValues(int[] counts) {
        if(counts[5] < k) {
            return 1;
        }
        if(counts[5] > k) {
            return 0;
        }
        for (int i = 0; i < counts.length - 1; i++) {
            if(counts[i] == 0) {
                return 1;
            }
        }
        return 2;
    }

    private int getIndex(char a) {
        switch (a) {
            case 'a':
                return 0;
            case 'e':
                return 1;
            case 'i':
                return 2;
            case 'o':
                return 3;
            case 'u':
                return 4;
            default:
                return 5;
        }
    }
}

