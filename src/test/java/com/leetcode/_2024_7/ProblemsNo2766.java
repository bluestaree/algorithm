package com.leetcode._2024_7;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 2766. 重新放置石块
 *
 * @author DHW
 * @date 2024/7/24 9:21
 * @Version 1.0
*/
public class ProblemsNo2766 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,1,3,3};
        int[] moveFrom = new int[]{1,3};
        int[] moveTo = new int[]{2,2};
        System.out.println("res = " + relocateMarbles(nums, moveFrom, moveTo));
    }

    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x : nums) {
            set.add(x);
        }

        for (int i = 0; i < moveFrom.length; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }

        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
}

