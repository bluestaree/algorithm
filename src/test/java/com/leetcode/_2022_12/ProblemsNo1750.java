package com.leetcode._2022_12;

import org.junit.Test;


/**
 * 1750. 删除字符串两端相同字符后的最短长度
 *
 * @author DHW
 * @date 2022/12/28 14:42
 * @Version 1.0
*/
public class ProblemsNo1750 {

    @Test
    public void solution() {
//        String s = "abbbbba";
        String s = "cabaabac";
//        String s = "bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb";
        System.out.println("res = " + minimumLength(s));
    }

    public int minimumLength(String s) {
        char[] chars = s.toCharArray();
        int preIndex = 0;
        int lastIndex = chars.length - 1;
        while (true) {
            char aChar = chars[preIndex];
            if(aChar != chars[lastIndex] || preIndex >= lastIndex) {
                break;
            }
            while(true) {
                boolean flag = false;
                if(preIndex == lastIndex && aChar == chars[preIndex] && aChar == chars[lastIndex]) {
                    return 0;
                }
                if(preIndex > lastIndex) {
                    break;
                }
                if(aChar == chars[preIndex]) {
                    preIndex++;
                    flag = true;
                }
                if(aChar == chars[lastIndex]) {
                    lastIndex--;
                    flag = true;
                }
                if(!flag) {
                    break;
                }
            }
        }
        return lastIndex - preIndex + 1;
    }
}
