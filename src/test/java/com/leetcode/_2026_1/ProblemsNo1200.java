package com.leetcode._2026_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 1200. 最小绝对差
 *
 * @author DHW
 * @date 2026/1/26 9: 14
 * @Version 1.0
*/
public class ProblemsNo1200 {

    @Test
    public void solution() {
        int[] arr = new int[]{1,2,2};
        System.out.println("res = " + minimumAbsDifference(arr));
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        int[] diff = new int[n - 1];
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            diff[i] = Math.abs(arr[i + 1] - arr[i]);
            minValue = Math.min(minValue, diff[i]);
        }
        for (int i = 0; i < n - 1; i++) {
            if (diff[i] == minValue) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                ans.add(pair);
            }
        }
        return ans;
    }

}

