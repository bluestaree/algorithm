package com.leetcode._2024_8;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * 551. 学生出勤记录 I
 *
 * @author DHW
 * @date 2024/8/18 11:12
 * @Version 1.0
*/
public class ProblemsNo551 {

    @Test
    public void solution() {
        String s = "PPALLP";
        System.out.println("res = " + checkRecord(s));
    }

    public boolean checkRecord(String s) {
        int a = s.indexOf("LLL");
        if(a >= 0) {
            return false;
        }
        int i = 0;
        int b = 0;
        while((i = s.indexOf("A", i)) != -1) {
            i++;
            if(++b > 1) {
                return false;
            }
        }
        return true;
    }
}

