package com.leetcode._2025_12;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 3074. 重新分装苹果
 *
 * @author DHW
 * @date 2025/12/24 8: 43
 * @Version 1.0
*/
public class ProblemsNo3074 {

    @Test
    public void solution() {
        int[] apple =  new int[]{5,2,1,2,5,2,1,2,5};
        int[] capacity =  new int[]{5,2,1,2,5,2,1,2,5};
        System.out.println("res = " + minimumBoxes(apple, capacity));
    }

    public int minimumBoxes(int[] apple, int[] capacity) {
        int ans = 0;
        int sum = 0;
        for (int num : apple) {
            sum += num;
        }
        Arrays.sort(capacity);
        for (int i = capacity.length - 1; i >= 0 && sum > 0; i--) {
            sum -= capacity[i];
            ans++;
        }
        return ans;
    }
}

