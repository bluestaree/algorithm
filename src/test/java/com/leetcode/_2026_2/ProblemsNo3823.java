package com.leetcode._2026_2;

import org.junit.Test;


/**
 * 3823. 反转一个字符串里的字母后反转特殊字符
 *
 * @author DHW
 * @date 2026/2/26 9: 59
 * @Version 1.0
*/
public class ProblemsNo3823 {

    @Test
    public void solution() {
        String s = ")ebc#da@f(";
        System.out.println("res = " + reverseByType(s));
    }

    public String reverseByType(String s) {
        char[] charArray = s.toCharArray();
        int mr = charArray.length - 1;
        int kr = charArray.length - 1;
        for (int i = 0; i < charArray.length - 1; i++) {
            if(charArray[i] < 'a'  && kr > i) {
                while(kr > i && charArray[kr] >= 'a') {
                    kr--;
                }
                char temp = charArray[i];
                charArray[i] = charArray[kr];
                charArray[kr] = temp;
                kr--;
            } else if(charArray[i] >= 'a'  && mr > i) {
                while(mr > i && charArray[mr] < 'a') {
                    mr--;
                }
                char temp = charArray[i];
                charArray[i] = charArray[mr];
                charArray[mr] = temp;
                mr--;
            }
        }
        return String.valueOf(charArray);
    }
}

