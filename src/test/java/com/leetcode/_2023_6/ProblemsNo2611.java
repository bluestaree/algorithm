package com.leetcode._2023_6;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;


/**
 * 2611. 老鼠和奶酪
 *
 * @author DHW
 * @date 2023/6/7 9:07
 * @Version 1.0
*/
public class ProblemsNo2611 {

    @Test
    public void solution() {
        int[] reward1 = new int[]{1,4,4,6,4};
        int[] reward2 = new int[]{6,5,3,6,1};
        int k = 1;
        System.out.println("res = " + miceAndCheese(reward1, reward2, k));
    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int res = 0;
        for (int i = 0; i < reward2.length; i++) {
            res += reward2[i];
            reward1[i] -= reward2[i];
        }
        Arrays.sort(reward1);
        for (int i = 0; i < k; i++) {
            res += reward1[reward1.length - i - 1];
        }
        return res;
    }
}
