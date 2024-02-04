package com.leetcode._2024_1;

import org.junit.Test;

import java.util.*;


/**
 * 2865. 美丽塔 I
 *
 * @author DHW
 * @date 2024/1/24 10:19
 * @Version 1.0
*/
public class ProblemsNo2865 {

    @Test
    public void solution() {
        List<Integer> maxHeights = new ArrayList<>();
        maxHeights.add(6);
        maxHeights.add(5);
        maxHeights.add(3);
        maxHeights.add(9);
        maxHeights.add(2);
        maxHeights.add(7);
        System.out.println("res = " + maximumSumOfHeights(maxHeights));
    }

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long res = 0l;
        for (int i = 0; i < maxHeights.size(); i++) {
            int num = maxHeights.get(i);
            long cur = num;
            for (int j = i - 1; j >= 0; j--) {
                num = Math.min(num, maxHeights.get(j));
                cur += num;
            }
            num = maxHeights.get(i);
            for (int k = i + 1; k < maxHeights.size(); k++) {
                num = Math.min(num, maxHeights.get(k));
                cur += num;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}

