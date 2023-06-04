package com.leetcode._2023_5;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 1003. 检查替换后的词是否有效
 *
 * @author DHW
 * @date 2023/5/3 11:50
 * @Version 1.0
*/
public class ProblemsNo1003 {

    @Test
    public void solution() {
        String s = "1231";
        System.out.println("res = " + isValid(s));
    }

    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            if(sb.length() >= 3 && sb.substring(sb.length() - 3).equals("abc")) {
                sb.delete(sb.length() - 3, sb.length());
            }
        }
        return sb.length() == 0;
    }
}
