package com.leetcode._2023_4;

import org.junit.Test;


/**
 * 2399. 检查相同字母间的距离
 *
 * @author DHW
 * @date 2023/4/9 11:32
 * @Version 1.0
*/
public class ProblemsNo2399 {

    @Test
    public void solution() {
        String s = "aa";
        int[] distance = new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println("res = " + checkDistances(s, distance));
    }

    public boolean checkDistances(String s, int[] distance) {
        int[] num = new int[26];
        for (int i = 0; i < num.length; i++) {
            num[i] = -1;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 97;
            if(num[index] == -1) {
                num[index] = i;
            } else if(i - num[index] - 1 != distance[index]) {
                return false;
            }
        }
        return true;
    }
}
