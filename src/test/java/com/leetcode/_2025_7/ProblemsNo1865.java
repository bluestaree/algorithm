package com.leetcode._2025_7;

import org.junit.Test;

import javax.lang.model.element.VariableElement;
import java.util.HashMap;


/**
 * 1865. 找出和为指定值的下标对
 *
 * @author DHW
 * @date 2025/7/6 10: 25
 * @Version 1.0
 */
public class ProblemsNo1865 {

    @Test
    public void solution() {
        FindSumPairs obj = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 1, 2, 2, 2, 3});
        obj.add(1, 3);
        int param_2 = obj.count(1);
        System.out.println("res = " + param_2);
    }

    class FindSumPairs {

        int[] nums1;
        int[] nums2;
        HashMap<Integer, Integer> map = new HashMap();


        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            for (int i : nums2) {
                map.merge(i, 1, Integer::sum);
            }
        }

        public void add(int index, int val) {
            map.merge(nums2[index], -1, Integer::sum);
            nums2[index] += val;
            map.merge(nums2[index], 1, Integer::sum);
        }

        public int count(int tot) {
            int res = 0;
            for (int i : nums1) {
                res += map.getOrDefault(tot - i, 0);
            }
            return res;
        }
    }

}

