package com.leetcode._2026_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 1170. 比较字符串最小字母出现频次
 *
 * @author DHW
 * @date 2026/7/21 10:04
 * @Version 1.0
*/
public class ProblemsNo1170 {

    @Test
    public void solution() {
        String[] queries = new String[]{"bbb","cc"};
        String[] words = new String[]{"a","aa","aaa","aaaa"};
        System.out.println("res = " + numSmallerByFrequency(queries, words));
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = words.length;
        int[] a = new int[n];
        for (int i = 0;i < n;i++) {
            a[i] = count(words[i]);
        }
        Arrays.sort(a);
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < queries.length; i++) {
            int cnt = count(queries[i]);
            int l = 0;
            int r = n - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (a[mid] <= cnt) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            ans[i] = n - r - 1;
        }
        return ans;
    }

    private int count(String word) {
        char[] charArray = word.toCharArray();
        Arrays.sort(charArray);
        int cnt = 1;
        for (int i = 1; i < charArray.length; i++) {
            if(charArray[i] == charArray[i-1]) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }

}
