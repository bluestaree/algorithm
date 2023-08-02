package com.leetcode._2023_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 415. 字符串相加
 *
 * @author DHW
 * @date 2023/7/6 9:32
 * @Version 1.0
*/
public class ProblemsNo415 {

    @Test
    public void solution() {
        String num1 = "11";
        String num2 = "123";
        System.out.println("res = " + addStrings(num1, num2));
    }

    public String addStrings(String num1, String num2) {
        StringBuffer str = new StringBuffer();
        int addNum = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1 ; i >= 0 || j >= 0;i--,j-- ) {
            int one = i >= 0 ? num1.charAt(i) - '0' : 0;
            int two = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = one + two + addNum;
            addNum = sum / 10;
            str.append(sum % 10);
        }
        if(addNum > 0) {
            str.append(addNum);
        }
        return str.reverse().toString();
    }
}
