package com.leetcode._2023_4;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * 2404. 出现最频繁的偶数元素
 *
 * @author DHW
 * @date 2023/4/13 11:32
 * @Version 1.0
*/
public class ProblemsNo2404 {

    @Test
    public void solution() {
        int[] nums = {1,2,3};
        System.out.println("res = " + mostFrequentEven(nums));
    }

    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }

        int res = -1;
        int maxNum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            Integer key = entry.getKey();
            if(value > maxNum) {
                maxNum = value;
                res = key;
            } else if(value == maxNum && key < res) {
                res = key;
            }
        }

        return res;
    }
}
