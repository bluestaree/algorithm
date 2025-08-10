package com.leetcode._2025_6;

import org.junit.Test;


/**
 * 1432. 改变一个整数能得到的最大差值
 *
 * @author DHW
 * @date 2025/6/15 10: 18
 * @Version 1.0
*/
public class ProblemsNo1432 {

    @Test
    public void solution() {
        int num = 111;
        System.out.println("res = " + minMaxDifference(num));
    }

    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        int n = s.length();
        int max = num;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) != '9') {
                max = Integer.parseInt(s.replace(s.charAt(i), '9'));
                break;
            }
        }
        int min = num;
        if(s.charAt(0) != '1') {
            min = Integer.parseInt(s.replace(s.charAt(0), '1'));
        } else {
            for (int i = 1; i < n; i++) {
                if(s.charAt(i) != '1' && s.charAt(i) != '0') {
                    min = Integer.parseInt(s.replace(s.charAt(i), '0'));
                    break;
                }
            }
        }
        return max - min;
    }
}

