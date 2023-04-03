package com.leetcode._2023_3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 1637. 两点之间不包含任何点的最宽垂直区域
 *
 * @author DHW
 * @date 2023/3/30 9:49
 * @Version 1.0
*/
public class ProblemsNo1637 {

    @Test
    public void solution() {
        int[][] points = new int[][]{new int[]{1,2}, new int[]{2,3}};
        System.out.println("res = " + maxWidthOfVerticalArea(points));
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        Integer[] array = Arrays.stream(points).map(x -> x[0]).sorted().toArray(Integer[]::new);
        int res = 0;
        for (int i = 1; i < array.length; i++) {
            res =  Math.max(res, array[i] - array[i-1]);
        }
        return res;
    }
}
