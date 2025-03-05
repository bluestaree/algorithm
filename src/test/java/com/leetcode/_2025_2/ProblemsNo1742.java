package com.leetcode._2025_2;

import org.junit.Test;


/**
 * 1742.  盒子中小球的最大数量
 *
 * @author DHW
 * @date 2025/2/13 8:44
 * @Version 1.0
 */
public class ProblemsNo1742 {

    @Test
    public void solution() {

        int lowLimit = 1;
        int highLimit = 2;
        System.out.println("res = " + countBalls(lowLimit, highLimit));
    }

    public int countBalls(int lowLimit, int highLimit) {
        int cnt[] = new int[50];
        int res = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int j = i;
            int cur = 0;
            while(j != 0) {
                cur += j % 10;
                j /= 10;
            }
            if(++cnt[cur] > res) {
                res = cnt[cur];
            }
        }
        return res;
    }
}
