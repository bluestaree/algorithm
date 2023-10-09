package com.leetcode._2023_9;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 1333. 餐厅过滤器
 *
 * @author DHW
 * @date 2023/9/27 10:26
 * @Version 1.0
*/
public class ProblemsNo1333 {

    @Test
    public void solution() {
        int[][] restaurants = new int[][]{new int[]{3,5,4,5,6}, new int[]{2,7,6,4,3}};
        int veganFriendly = 1;
        int maxPrice = 1;
        int maxDistance = 1;
        System.out.println("res = " + filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance));
    }

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .filter(r -> r[2] >= veganFriendly)
                .filter(r -> r[3] <= maxPrice)
                .filter(r -> r[4] <= maxDistance)
                .sorted((x, y) -> x[1] - y[1] == 0 ? y[0] - x[0] : y[1] - x[1])
                .map(r -> r[0])
                .collect(Collectors.toList());
    }
}
