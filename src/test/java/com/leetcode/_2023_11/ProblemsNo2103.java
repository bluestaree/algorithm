package com.leetcode._2023_11;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 * 2103. 环和杆
 *
 * @author DHW
 * @date 2023/11/2 8:58
 * @Version 1.0
 */
public class ProblemsNo2103 {

    @Test
    public void solution() {
        String rings = "B0B6G0R6R0R6G9";
        System.out.println("minimum = " + countPoints(rings));
    }

    public int countPoints(String rings) {
        int res = 0;
        int[][] m = new int[10][3];
        for (int i = 0; i < rings.length(); i+=2) {
            char color = rings.charAt(i);
            int index = rings.charAt(i+1) - '0';
            if(color == 'R') {
                m[index][0] = 1;
            } else if(color == 'G') {
                m[index][1] = 1;
            } else {
                m[index][2] = 1;
            }
        }
        for (int i = 0; i < m.length; i++) {
            if(m[i][0] == 1 && m[i][1] == 1 && m[i][2] == 1) {
                res++;
            }
        }
        return res;
    }
}