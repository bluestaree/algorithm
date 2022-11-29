package com.leetcode._2022_10;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;


/**
 * 1784. 检查二进制字符串字段
 *
 * @author DHW
 * @date 2022/10/3 12:33
 * @Version 1.0
*/
public class ProblemsNo1784 {

    @Test
    public void solution() {
        String s = "110";
        System.out.println("s = " + checkOnesSegment(s));
    }

    public boolean checkOnesSegment(String s) {
        if(s.length() <= 2) {
            return true;
        }
        char[] chars = s.toCharArray();
        boolean isContinue = false;
        if(chars[1] == '1') {
            isContinue = true;
        }

        for (int i = 2; i < chars.length; i++) {
            if(chars[i] == '1') {
                if(isContinue) {
                    continue;
                }
                return false;
            }else {
                isContinue = false;
            }
        }
        return true;
    }

}
