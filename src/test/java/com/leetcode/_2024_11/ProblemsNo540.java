package com.leetcode._2024_11;

import org.junit.Test;


/**
 * 540. 有序数组中的单一元素
 *
 * @author DHW
 * @date 2024/11/10 10: 46
 * @Version 1.0
*/
public class ProblemsNo540 {

    @Test
    public void solution() {
        int[] nums = new int[]{3,3,7,7,10,11,11};
        System.out.println("res = " + singleNonDuplicate(nums));
    }

    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int mid = (l+r) / 2;
            if(mid % 2 == 1 && nums[mid - 1] != nums[mid]) {
                r = mid;
            } else if(mid % 2 == 0 && nums[mid] != nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}

