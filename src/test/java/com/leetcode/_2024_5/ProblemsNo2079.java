package com.leetcode._2024_5;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2079. 给植物浇水
 *
 * @author DHW
 * @date 2024/5/8 8:49
 * @Version 1.0
*/
public class ProblemsNo2079 {

    @Test
    public void solution() {
        int[] plants = new int[]{1,1,1,4,2,3};
        int capacity = 1;
        System.out.println("res = " + wateringPlants(plants, capacity));
    }

    public int wateringPlants(int[] plants, int capacity) {
        int res = 0;
        int n = plants.length;
        int curCapacity = capacity;
        for (int i = 0; i < n; i++) {
            curCapacity -= plants[i];
            if(i + 1 < n && curCapacity < plants[i+1]) {
                res += (i+1) * 2;
                curCapacity = capacity;
            }
            res++;
        }
        return res;
    }
}

