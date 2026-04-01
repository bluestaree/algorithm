package com.leetcode._2026_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 658. 找到 K 个最接近的元素
 *
 * @author DHW
 * @date 2026/3/5 9: 50
 * @Version 1.0
*/
public class ProblemsNo658 {

    @Test
    public void solution() {
        int[] arr = new int[]{2,2,3,3};
        int k = 5;
        int x = 5;
        System.out.println("res = " + findClosestElements(arr, k, x));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;
        while (right - left + 1 > k) {
            int a = Math.abs(arr[left] - x);
            int b = Math.abs(arr[right] - x);
            if(a <= b) {
                right--;
            } else {
                left++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

}

