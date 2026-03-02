package com.leetcode._2026_2;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 1356. 根据数字二进制下 1 的数目排序
 *
 * @author DHW
 * @date 2026/2/25 8: 46
 * @Version 1.0
*/
public class ProblemsNo1356 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,0,1,0,1};
        System.out.println("res = " + sortByBits(nums));
    }


    public int[] sortByBits(int[] arr) {
        int[] map = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            map[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(map);
        for (int i = 0; i < map.length; i++) {
            map[i] = map[i] % 10000000;
        }
        return map;
    }

}

