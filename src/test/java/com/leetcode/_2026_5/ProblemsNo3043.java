package com.leetcode._2026_5;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 3043. 最长公共前缀的长度
 *
 * @author DHW
 * @date 2026/5/21 9: 41
 * @Version 1.0
 */
public class ProblemsNo3043 {

    @Test
    public void solution() {
        int[] arr1 = new int[]{1,3,54,4,7};
        int[] arr2 = new int[]{1,3,54,4,7};
        System.out.println("res = " + longestCommonPrefix(arr1, arr2));
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr1) {
            while(i > 0) {
                set.add(i);
                i /= 10;
            }
        }
        int mx = 0;
        for (int i : arr2) {
            while(i > 0 && !set.contains(i)) {
                i /= 10;
            }
            mx = Math.max(mx, i);
        }

        return mx > 0 ? Integer.toString(mx).length() : 0;
    }

}

