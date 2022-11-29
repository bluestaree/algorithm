package com.leetcode._2022_11;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 1662. 检查两个字符串数组是否相等
 *
 * @author DHW
 * @date 2022/11/1 20:11
 * @Version 1.0
*/
public class ProblemsNo1662 {

    @Test
    public void solution() {
        String[] arr = new String[]{"ab","c"};
        String[] arr1 = new String[]{"a","bcd"};
        System.out.println("arr = " + arrayStringsAreEqual(arr, arr1));
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer sb = new StringBuffer();
        for (String s : word1) {
            sb.append(s);
        }
        char[] chars = sb.toString().toCharArray();
        int index = 0;
        for (String s : word2) {
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if(index == chars.length || chars[index] != charArray[i]) {
                    return false;
                }
                index++;
            }
        }
        if(index != chars.length) {
            return false;
        }
        return true;
    }
}
