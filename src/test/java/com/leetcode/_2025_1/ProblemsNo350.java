package com.leetcode._2025_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * 350. 两个数组的交集 II
 *
 * @author DHW
 * @date 2025/1/30 10: 32
 * @Version 1.0
*/
public class ProblemsNo350 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{2,3,1,1,4};
        int[] nums2 = new int[]{2,3,1,1,4};
        System.out.println("res = " + intersect(nums1, nums2));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] cnt = new int[1001];
        for (int i : nums1) {
            cnt[i]++;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if(cnt[i]-- > 0) {
                list.add(i);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

