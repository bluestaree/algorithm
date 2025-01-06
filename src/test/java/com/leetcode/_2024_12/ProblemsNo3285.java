package com.leetcode._2024_12;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 3285. 找到稳定山的下标
 *
 * @author DHW
 * @date 2024/12/19 8: 33
 * @Version 1.0
*/
public class ProblemsNo3285 {

    @Test
    public void solution() {
        int[] height = new int[]{7,4,1};
        int threshold = 5;
        System.out.println("res = " + stableMountains(height, threshold));
    }

    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < height.length; i++) {
            if(height[i - 1] > threshold) {
                list.add(i);
            }
        }
        return list;
    }
}

