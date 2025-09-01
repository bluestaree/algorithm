package com.leetcode._2025_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 3477. 水果成篮 II
 *
 * @author DHW
 * @date 2025/8/5 9: 06
 * @Version 1.0
*/
public class ProblemsNo3477 {

    @Test
    public void solution() {
        int[] fruits =  new int[]{4,2,5};
        int[] baskets =  new int[]{3,3,3,1,2,1,1,2,3,3,4};
        System.out.println("res = " + numOfUnplacedFruits(fruits, baskets));
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int ans = n;
        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < baskets.length; j++) {
                if(baskets[j] >= fruits[i]) {
                    ans--;
                    baskets[j] = 0;
                    break;
                }
            }
        }
        return ans;
    }
}

