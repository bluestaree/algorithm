package com.leetcode._2026_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 167. 两数之和 II - 输入有序数组
 *
 * @author DHW
 * @date 2026/3/6 9: 48
 * @Version 1.0
*/
public class ProblemsNo167 {

    @Test
    public void solution() {
        int[] numbers = new int[]{2,2,3,3};
        int target = 5;
        System.out.println("res = " + twoSum(numbers, target));
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}

