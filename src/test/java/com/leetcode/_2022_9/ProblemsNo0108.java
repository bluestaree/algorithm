package com.leetcode._2022_9;

import org.junit.Test;


/**
 * 0108. 零矩阵
 *
 * @author DHW
 * @date 2022/9/30 9:47
 * @Version 1.0
*/
public class ProblemsNo0108 {

    @Test
    public void solution() {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println("true = " + isFlipedString(s1, s2));
    }

    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        return s1.concat(s1).contains(s2);
    }
}
