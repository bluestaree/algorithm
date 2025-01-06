package com.leetcode._2024_12;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 1705. 吃苹果的最大数目
 *
 * @author DHW
 * @date 2024/12/24 9: 05
 * @Version 1.0
*/
public class ProblemsNo1705 {

    @Test
    public void solution() {
        int[] apples = new int[]{1,2,3,5,2};
        int[] days = new int[]{3,2,1,4,2};
        System.out.println("res = " + eatenApples(apples, days));
    }

    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        int res = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            if(apples[i] != 0) {
                queue.add(new int[]{apples[i], i + days[i]});
            }
            while(!queue.isEmpty()) {
                int[] a = queue.poll();
                if(a[0] == 0 || i == a[1]) {
                    continue;
                }
                res++;
                a[0]--;
                queue.add(a);
                if(i < n - 1) {
                    break;
                }
                i++;
            }
        }
        return res;
    }
}

