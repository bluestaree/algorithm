package com.leetcode._2026_10;

import org.junit.Test;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * 2913. 子数组不同元素数目的平方和 I
 *
 * @author DHW
 * @date 2024/10/15 8: 35
 * @Version 1.0
*/
public class ProblemsNo2913 {

    @Test
    public void solution() {
        List<Integer> nums1 = new ArrayList<>();
        nums1.add(3);
        nums1.add(6);
        System.out.println("res = " + sumCounts(nums1));
    }

    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.size(); i++) {
            set.clear();
            for (int j = i; j < nums.size(); j++) {
                set.add(nums.get(j));
                int size = set.size();
                ans += size * size;
            }
        }
        return ans;
    }
}

