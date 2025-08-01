package com.leetcode._2025_7;

import org.junit.Test;


/**
 * 1957. 删除字符使字符串变好
 *
 * @author DHW
 * @date 2025/7/15 9: 22
 * @Version 1.0
*/
public class ProblemsNo1957 {

    @Test
    public void solution() {
        String s = "abbcccc";
        System.out.println("res = " + makeFancyString(s));
    }

    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        int l = 0;
        sb.append(charArray[0]);
        for (int i = 1; i < charArray.length; i++) {
            if(charArray[l] != charArray[i]) {
                l = i;
            }
            if(i - l >= 2){
                continue;
            }
            sb.append(charArray[0]);
        }
        return sb.toString();
    }
}

