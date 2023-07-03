package com.leetcode._2023_6;

import org.junit.Test;


/**
 * 1401. 圆和矩形是否有重叠
 *
 * @author DHW
 * @date 2023/6/25 11:36
 * @Version 1.0
*/
public class ProblemsNo1401 {

    @Test
    public void solution() {
        int radius, xCenter, yCenter, x1, y1, x2, y2;
        radius = 1;
        xCenter = 1;
        yCenter = 1;
        x1 = -3;
        y1 = -3;
        x2 = 3;
        y2 = 3;

        System.out.println("res = " + checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2));
    }

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // 正方形在圆形得右边
        if(x1 >= xCenter) {
            // 正方形在圆形右上方
            if(y1 >= yCenter) {
                // 计算圆点到 左下角距离
                double dis = Math.sqrt(Math.pow(x1 - xCenter, 2) + Math.pow(y1 - yCenter, 2));
                if(dis <= radius) {
                    return true;
                }
            }
            if(y1 < yCenter && yCenter <= y2) {
                // 判断x距离
                if(x1 <= xCenter + radius) {
                    return true;
                }
            }
            // 正方形在圆形右下方
            if(yCenter > y2) {
                // 计算圆点到 左上角距离
                double dis = Math.sqrt(Math.pow(x1 - xCenter, 2) + Math.pow(y2 - yCenter, 2));
                if(dis <= radius) {
                    return true;
                }
            }
        }
        // 正方形在圆形得左边
        else if(x2 <= xCenter) {
            // 正方形在圆形左上方
            if(y1 >= yCenter) {
                // 计算圆点到 右下角距离
                double dis = Math.sqrt(Math.pow(x2 - xCenter, 2) + Math.pow(y1 - yCenter, 2));
                if(dis <= radius) {
                    return true;
                }
            }
            if(y1 < yCenter && yCenter <= y2) {
                // 判断x距离
                if(x2 >= xCenter - radius) {
                    return true;
                }
            }
            // 正方形在圆形左下方
            if(yCenter > y2) {
                // 计算圆点到 右上角距离
                double dis = Math.sqrt(Math.pow(x2 - xCenter, 2) + Math.pow(y2 - yCenter, 2));
                if(dis <= radius) {
                    return true;
                }
            }
        }
        // 判断是否重叠情况
        else {
            if(y1 <= yCenter && yCenter <= y2) {
                return true;
            }
            if(y1 - radius <= yCenter && yCenter <= y1) {
                return true;
            }
            if(y2 <= yCenter && yCenter <= y2 + radius) {
                return true;
            }
        }
        return false;
    }
}
