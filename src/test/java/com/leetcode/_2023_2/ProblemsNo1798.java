package com.leetcode._2023_2;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;


/**
 * 1798. 你能构造出连续值的最大数目
 *
 * @author DHW
 * @date 2023/2/4 11:10
 * @Version 1.0
*/
public class ProblemsNo1798 {

    @Test
    public void solution() {
        int[] coins = new int[]{-1,0,1,1,1};
        System.out.println("res = " + getMaximumConsecutive(coins));
    }

    public int getMaximumConsecutive(int[] coins) {
        int res = 1;
        Arrays.sort(coins);
        for (int i : coins) {
            if (i > res) {
                break;
            }
            res += i;
        }
        return res;
    }
}
