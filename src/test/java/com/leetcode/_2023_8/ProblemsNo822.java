package com.leetcode._2023_8;

import org.junit.Test;

import java.util.*;


/**
 * 822. 翻转卡片游戏
 *
 * @author DHW
 * @date 2023/7/19 10:28
 * @Version 1.0
*/
public class ProblemsNo822 {

    @Test
    public void solution() {
        int[] fronts = new int[]{-2,-1,8,9,6};
        int[] backs = new int[]{-2,-1,8,9,6};
        System.out.println("res = " + flipgame(fronts, backs));
    }

    public int flipgame(int[] fronts, int[] backs) {
        int length = fronts.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if(fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }

        int res = 2001;
        for (int num : fronts) {
            if (num < res && !set.contains(num)){
                res = num;
            }
        }
        for (int num : backs) {
            if (num < res && !set.contains(num)) {
                res = num;
            }
        }
        return res % 2001;
    }
}
