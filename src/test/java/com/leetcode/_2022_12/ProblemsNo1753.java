package com.leetcode._2022_12;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1753. 移除石子的最大得分
 *
 * @author DHW
 * @date 2022/12/21 10:35
 * @Version 1.0
*/
public class ProblemsNo1753 {

    @Test
    public void solution() {
        int a = 8;
        int b = 16;
        int c = 22;
        System.out.println("res = " + maximumScore(a, b, c));
    }

    public int maximumScore(int a, int b, int c) {
        // 每次找到a, b, c中最大的两个，移除1
        int[] array = {a, b, c};
        int cnt = 0;
        while(true) {
            Arrays.sort(array);
            if (array[0] == 0 && array[1] == 0) {
                break;
            }
            array[1]--;
            array[2]--;
            cnt++;
        }
        return cnt;
    }
}
