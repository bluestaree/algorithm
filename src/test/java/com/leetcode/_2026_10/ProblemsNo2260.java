package com.leetcode._2026_10;

import org.junit.Test;

import java.util.HashMap;


/**
 * 2260. 必须拿起的最小连续卡牌数
 *
 * @author DHW
 * @date 2026/10/8 9:15
 * @Version 1.0
*/
public class ProblemsNo2260 {

    @Test
    public void solution() {
        int[] cards = new int[]{0,0};
        System.out.println("res = " + minimumCardPickup(cards));
    }

    public int minimumCardPickup(int[] cards) {
        int ans = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            Integer i1 = map.getOrDefault(cards[i], -1);
            if(i1 >= 0) {
                ans = Math.min(ans, i - i1 + 1);
            }
            map.put(cards[i], i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

