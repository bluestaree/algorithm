package com.leetcode._2023_5;

import org.junit.Test;


/**
 * 2437. 有效时间的数目
 *
 * @author DHW
 * @date 2023/5/9 9:36
 * @Version 1.0
*/
public class ProblemsNo2437 {

    @Test
    public void solution() {
        String time = "?5:00";
        System.out.println("res = " + countTime(time));
    }

    public int countTime(String time) {
        int res = 0;
        int[] ints = new int[]{3,5,6,10};
        char[] chars = time.toCharArray();
        int hh = 1;
        int mm = 1;
        if(chars[0] == '?' && chars[1] == '?') {
            hh = 24;
        } else if(chars[0] == '?') {
            if(chars[1] < '4') {
                hh = 3;
            }
            if(chars[1] > '4') {
                hh = 2;
            }
            if(chars[1] == '4') {
                if((chars[3] == '?' && chars[4] == '?') || (chars[3] == '0' && chars[4] == '0')) {
                    hh = 3;
                } else {
                    hh = 2;
                }
            }
        } else if(chars[1] == '?') {
            if(chars[0] < '2') {
                hh = 10;
            } else {
                hh = 4;
            }
        }

        if(chars[3] == '?' && chars[4] == '?') {
            mm = 60;
        } else if(chars[3] == '?') {
            mm = 6;
        } else if(chars[4] == '?'){
            mm = 10;
        }
        return hh * mm;
    }
}
