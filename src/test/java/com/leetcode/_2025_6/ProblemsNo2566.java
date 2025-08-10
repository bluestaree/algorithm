package com.leetcode._2025_6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 2566. 替换一个数字后的最大差值
 *
 * @author DHW
 * @date 2025/6/14 9: 55
 * @Version 1.0
*/
public class ProblemsNo2566 {

    @Test
    public void solution() {
        int num = 11891;
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
        int min = Integer.parseInt(s.replace(s.charAt(0), '0'));
        return max - min;
    }
}

