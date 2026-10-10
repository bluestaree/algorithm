package com.leetcode._2026_10;

import org.junit.Test;

import java.awt.image.Kernel;
import java.util.HashMap;


/**
 * 2001. 可互换矩形的组数
 *
 * @author DHW
 * @date 2023/10/9 10:07
 * @Version 1.0
*/
public class ProblemsNo2001 {

    @Test
    public void solution() {
        int[][] rectangles = new int[][]{new int[]{3,5}, new int[]{2,7}};
        System.out.println("res = " + interchangeableRectangles(rectangles));
    }

    public long interchangeableRectangles(int[][] rectangles) {
        long ans = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        for (int[] rectangle : rectangles) {
            double x = rectangle[0] * 1.0 / rectangle[1];
            Integer num = map.getOrDefault(x, 0);
            ans += num;
            map.put(x, num + 1);
        }
        return ans;
    }
}
