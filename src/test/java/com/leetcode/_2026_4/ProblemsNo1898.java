package com.leetcode._2026_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


/**
 * 1898. 可移除字符的最大数目
 *
 * @author DHW
 * @date 2026/4/24 9: 34
 * @Version 1.0
 */
public class ProblemsNo1898 {

    @Test
    public void solution() {
        String s = "abcacb";
        String p = "ab";
        int[] removable = new int[]{3,1,0};
        System.out.println("sortArrayByParity(nums) = " + maximumRemovals(s, p, removable));
    }

    public int maximumRemovals(String s, String p, int[] removable) {
        int i = 0;
        int j = removable.length-1;
        while(i <= j){
            int m = i + (j-i)/2;
            StringBuffer sb = new StringBuffer(s);
            for(int left = 0; left <= m; left++){
                sb.setCharAt(removable[left], ' ');
            }
            if(!isSubsequence(sb.toString(), p)){j = m-1;}
            else{i = m+1;}
        }
        return j+1;
    }

    public boolean isSubsequence(String s, String p) {
        int n = p.length(), m = s.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (p.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}

