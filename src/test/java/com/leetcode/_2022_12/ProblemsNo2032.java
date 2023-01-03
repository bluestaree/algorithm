package com.leetcode._2022_12;

import org.junit.Test;

import java.util.*;


/**
 * 2032. 至少在两个数组中出现的值
 *
 * @author DHW
 * @date 2022/12/29 9:21
 * @Version 1.0
*/
public class ProblemsNo2032 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{1,1,3,2};
        int[] nums2 = new int[]{2,3};
        int[] nums3 = new int[]{3};
        System.out.println("res = " + twoOutOfThree(nums1, nums2, nums3));
    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums1).distinct().forEach(c->map.put(c,map.getOrDefault(c,0) + 1));
        Arrays.stream(nums2).distinct().forEach(c->map.put(c,map.getOrDefault(c,0) + 1));
        Arrays.stream(nums3).distinct().forEach(c->map.put(c,map.getOrDefault(c,0) + 1));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }
        return list;
    }
}
