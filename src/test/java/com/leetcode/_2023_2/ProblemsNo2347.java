package com.leetcode._2023_2;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * 2347. 设计一个验证系统
 *
 * @author DHW
 * @date 2023/2/20 11:10
 * @Version 1.0
*/
public class ProblemsNo2347 {

    @Test
    public void solution() {
        int[] ranks = new int[]{1,2,3,4,5};
        char[] suits = new char[]{1,2,3,4,5};
        System.out.println("res = " + bestHand(ranks, suits));
    }

    public String bestHand(int[] ranks, char[] suits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ranks.length; i++) {
            map.put(ranks[i], map.getOrDefault(ranks[i], 0) + 1);
        }
        int size = map.size();
        switch (size) {
            case 2:
                return "Three of a Kind";
            case 3:
                for (Integer value : map.values()) {
                    if(value == 3) {
                        return "Three of a Kind";
                    }
                }
            case 4:
                return "Pair";
        }
        char suit = suits[0];
        for (int i = 1; i < suits.length; i++) {
            if(suit != suits[i]) {
                return "High Card";
            }
        }
        return "Flush";
    }
}
