package com.leetcode._2023_8;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;


/**
 * 823. 带因子的二叉树
 *
 * @author DHW
 * @date 2023/8/29 9:10
 * @Version 1.0
*/
public class ProblemsNo823 {

    @Test
    public void solution() {
        int[] nums = new int[]{18865777,36451879,36878647};
        System.out.println("res = " + numFactoredBinaryTrees(nums));
    }

    public int numFactoredBinaryTrees(int[] arr) {
        long mod = 1000000007;
        HashMap<Integer, Long> map = new HashMap<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], 1L);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <=i; j++) {
                if(1L * arr[i] * arr[j] > arr[arr.length - 1]) {
                    break;
                }
                int num = arr[i] * arr[j];
                if(map.containsKey(num)) {
                    if(i == j) {
                        map.put(num, (map.get(num) + (map.get(arr[i]) * map.get(arr[j]))) % mod);
                    } else {
                        map.put(num, (map.get(num) + (2 * map.get(arr[i]) * map.get(arr[j]))) % mod);
                    }
                }
            }
        }
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += map.get(arr[i]);
            res %= mod;
        }
        return (int)res;
    }
}
