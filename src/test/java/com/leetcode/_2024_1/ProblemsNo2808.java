package com.leetcode._2024_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 2808. 使循环数组所有元素相等的最少秒数
 *
 * @author DHW
 * @date 2024/1/30 9:31
 * @Version 1.0
*/
public class ProblemsNo2808 {

    @Test
    public void solution() {
        List<Integer> nums = new ArrayList<>();
        nums.add(6);
        nums.add(5);
        nums.add(3);
        nums.add(9);
        nums.add(2);
        nums.add(7);
        System.out.println("res = " + minimumSeconds(nums));
    }

    public int minimumSeconds(List<Integer> nums) {
            int n = nums.size();
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                List<Integer> aDefault = map.getOrDefault(nums.get(i), new ArrayList<>());
                aDefault.add(i);
                map.put(nums.get(i), aDefault);
            }

            int res = n;
            for (List<Integer> list : map.values()) {
                int num = n - (list.get(list.size() - 1) - list.get(0));
                for (int i = 1; i < list.size(); i++) {
                    num = Math.max(num, list.get(i) - list.get(i-1));
                }
                res = Math.min(res, num / 2);
            }
            return res;
    }
}

