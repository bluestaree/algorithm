package com.leetcode._2026_3;

import org.junit.Test;


/**
 * 2105. 给植物浇水 II
 *
 * @author DHW
 * @date 2026/3/4 10: 24
 * @Version 1.0
*/
public class ProblemsNo2105 {

    @Test
    public void solution() {
        int[] plants = new int[]{2,2,3,3};
        int capacityA = 5;
        int capacityB = 5;
        System.out.println("res = " + minimumRefill(plants, capacityA, capacityB));
    }

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int left = 0, right = plants.length - 1;
        int ans = 0;
        int tempA = capacityA, tempB = capacityB;
        while (left <= right) {
            if(left == right) {
                int capacity = Math.max(tempA, tempB);
                if(capacity < plants[left]) {
                    ans++;
                }
                break;
            }
            if(plants[left] > tempA) {
                tempA = capacityA;
                ans++;
            }
            if(plants[right] > tempB) {
                tempB = capacityB;
                ans++;
            }
            tempA -= plants[left++];
            tempB -= plants[right--];
        }
        return ans;
    }

}

