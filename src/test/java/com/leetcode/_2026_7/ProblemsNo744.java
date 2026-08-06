package com.leetcode._2026_7;

import org.junit.Test;


/**
 * 744. 寻找比目标字母大的最小字母
 *
 * @author DHW
 * @date 2026/7/15 9: 13
 * @Version 1.0
 */
public class ProblemsNo744 {

    @Test
    public void solution() {
        char[] letters = new char[]{'x','x','y','y'};
        char target = 'z';
        System.out.println("= res = " + nextGreatestLetter(letters, target));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(letters[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return letters[l % letters.length];
    }
}

