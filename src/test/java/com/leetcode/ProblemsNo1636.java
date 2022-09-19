package com.leetcode;

import org.junit.Test;

import java.util.*;


/**
 * 1636. 按照频率将数组升序排序
 *
 * @author DHW
 * @date 2022/9/19 14:03
 * @Version 1.0
*/
public class ProblemsNo1636 {

    @Test
    public void solution() {
        int[] nums = new int[]{-1,1,-6,4,5,-6,1,4,1};
        for (int i : frequencySort(nums)) {
            System.out.println("nums = " + i);
        }
    }

    public int[] frequencySort(int[] nums) {
        int length = nums.length;
        if(length == 1) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Integer> arrayList = new ArrayList<>(map.keySet());
        arrayList.sort((o1, o2) -> {
            int i = map.get(o1) - map.get(o2);
            if(i == 0) {
                i = o2 - o1;
            }
            return i;
        });

        int[] result = new int[length];
        int j = 0;
        for (Integer num : arrayList) {
            Integer count = map.get(num);
            for (int i = j; i < j + count; i++) {
                result[i] = num;
            }
            j += count;
        }
        return result;
    }
}
