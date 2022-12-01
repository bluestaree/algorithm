package com.leetcode._2022_12;

import org.junit.Test;


/**
 * 1779. 找到最近的有相同 X 或 Y 坐标的点
 *
 * @author DHW
 * @date 2022/12/1 16:03
 * @Version 1.0
*/
public class ProblemsNo1779 {

    @Test
    public void solution() {
        int[][] points = new int[][]{new int[]{1,2},new int[]{3,1},new int[]{2,4},new int[]{2,3},new int[]{4,4}};
        int x = 3;
        int y = 4;
        System.out.println("res = " + nearestValidPoint(x, y, points));
    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            if(x1 == x || y1 == y) {
                // 计算距离
                int res = Math.abs(x - x1) + Math.abs(y - y1);
                if(res < min) {
                    index = i;
                    min = res;
                }
            }
        }
        return index;
    }
}
