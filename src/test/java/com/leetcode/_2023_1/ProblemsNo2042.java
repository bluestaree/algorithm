package com.leetcode._2023_1;

import org.junit.Test;


/**
 * 2042. 检查句子中的数字是否递增
 *
 * @author DHW
 * @date 2023/1/3 9:40
 * @Version 1.0
*/
public class ProblemsNo2042 {

    @Test
    public void solution() {
        String s = "4 5 11 26";
        System.out.println("res = " + areNumbersAscending(s));
    }

    public boolean areNumbersAscending(String s) {
        int pre = -1;
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            char[] chars = split[i].toCharArray();
            if(Character.isDigit(chars[0])) {
                int now = Integer.parseInt(split[i]);
                if(pre >= now) {
                    return false;
                }
                pre = now;
            }
        }
        return true;
    }
}
