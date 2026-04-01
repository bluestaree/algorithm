package com.leetcode._2026_3;

import org.junit.Test;


/**
 * 1750. 删除字符串两端相同字符后的最短长度
 *
 * @author DHW
 * @date 2026/3/2 10: 30
 * @Version 1.0
*/
public class ProblemsNo1750 {

    @Test
    public void solution() {
        String s = "cat and mice";
        System.out.println("res = " + minimumLength(s));
    }

    public int minimumLength(String s) {
        char[] charArray = s.toCharArray();
        int left = 0, right = charArray.length - 1;
        while (left < right && charArray[left] == charArray[right]) {
            char c = charArray[left];
            while (left <= right && charArray[left] == c) {
                left++;
            }
            while (left <= right && charArray[right] == c) {
                right--;
            }
        }
        return right - left + 1;
    }
}

