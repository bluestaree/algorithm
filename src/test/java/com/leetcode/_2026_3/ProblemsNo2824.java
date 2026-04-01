package com.leetcode._2026_3;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 2824. 统计和小于目标的下标对数目
 *
 * @author DHW
 * @date 2026/3/11 9: 44
 * @Version 1.0
*/
public class ProblemsNo2824 {

    private static final Log log = LogFactory.getLog(ProblemsNo2824.class);

    @Test
    public void solution() {
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(5);
        nums.add(3);
        nums.add(1);
        int target = 5;
        System.out.println("res = " + countPairs(nums, target));
    }

    public int countPairs(List<Integer> nums, int target) {
        int ans = 0;
        Collections.sort(nums);
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            if (nums.get(left) + nums.get(right) < target) {
                ans += right - left;
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

}

