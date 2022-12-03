package com.leetcode._2022_11;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1732. 找到最高海拔
 *
 * @author DHW
 * @date 2022/11/19 10:57
 * @Version 1.0
*/
public class ProblemsNo1732 {

    @Test
    public void solution() {
        int[] gain = new int[]{-4,-3,-2,-1,4,3,2};
        System.out.println("arr = " + largestAltitude(gain));
    }

    public int largestAltitude(int[] gain) {
        int[] num = new int[gain.length+1];
        int res = num[0];
        for (int i = 0; i < gain.length; i++) {
            num[i+1] = num[i] + gain[i];
            if(res < num[i+1]) {
                res = num[i+1];
            }
        }
        return res;
    }

}
