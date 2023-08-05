package com.leetcode._2023_7;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


/**
 * 167. 两数之和 II - 输入有序数组
 *
 * @author DHW
 * @date 2023/7/8 10:57
 * @Version 1.0
*/
public class ProblemsNo167 {

    @Test
    public void solution() {
        int[] numbers = new int[]{-10,-8,-2,1,2,5,6};
        int target = 0;
        System.out.println("res = " + twoSum(numbers, target));
    }

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{-1, -1};
    }

}
