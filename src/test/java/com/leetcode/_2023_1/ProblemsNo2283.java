package com.leetcode._2023_1;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;


/**
 * 2283. 判断一个数的数字计数是否等于数位的值
 *
 * @author DHW
 * @date 2023/1/11 13:40
 * @Version 1.0
*/
public class ProblemsNo2283 {

    @Test
    public void solution() {
        String n = "030";
        System.out.println("res = " + digitCount(n));
    }

    public boolean digitCount(String num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int number = chars[i] - '0';
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            int number = chars[i] - '0';
            Integer count = map.getOrDefault(i, 0);
            if(count != number) {
                return false;
            }
        }
        return true;
    }
}
