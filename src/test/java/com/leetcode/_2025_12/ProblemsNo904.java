package com.leetcode._2025_12;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;


/**
 * 904. 水果成篮
 *
 * @author DHW
 * @date 2025/12/19 8: 52
 * @Version 1.0
*/
public class ProblemsNo904 {

    @Test
    public void solution() {
        int[] fruits =  new int[]{3,3,3,3,3,3,3,1,3,1,1,2,3,3,4};
        System.out.println("res = " + totalFruit(fruits));
    }

    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int l = 0;
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], i);
            if (map.size() > 2) {
                Integer minIndex = map.values().stream().min(Integer::compareTo).get();
                map.remove(fruits[minIndex]);
                l = minIndex + 1;
            }
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}

