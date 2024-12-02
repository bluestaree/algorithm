package com.leetcode._2024_11;

import org.junit.Test;


/**
 * 3206. 交替组 I
 *
 * @author DHW
 * @date 2024/11/26 8: 30
 * @Version 1.0
*/
public class ProblemsNo3206 {

    @Test
    public void solution() {
        int[] colors = new int[]{0,1,0,0,1};
        System.out.println("res = " + numberOfAlternatingGroups(colors));
    }

    public int numberOfAlternatingGroups(int[] colors) {
        int res = 0;
        for (int i = 0, j = 2; i < colors.length; i++,j++) {
            if(colors[i] == colors[j % colors.length] && colors[i] != colors[(i+1) % colors.length]) {
                res++;
            }
        }
        return res;
    }
}

