package com.leetcode._2023_9;

import org.junit.Test;


/**
 * 2605. 从两个数字数组里生成最小数字
 *
 * @author DHW
 * @date 2023/9/5 10:08
 * @Version 1.0
*/
public class ProblemsNo2605 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{3,5,2,6};
        int[] nums2 = new int[]{3,1,7};
        System.out.println("res = " + minNumber(nums1, nums2));
    }

    public int minNumber(int[] nums1, int[] nums2) {
        int[] count = new int[10];
        int num1 = 10;
        for (int i = 0; i < nums1.length; i++) {
            count[nums1[i]] = 1;
            num1 = Math.min(num1, nums1[i]);
        }
        int res = 30;
        boolean flag = false;
        for (int i = 0; i < nums2.length; i++) {
            if(count[nums2[i]] == 1) {
                flag = true;
                res = Math.min(res, nums2[i]);
            }
            if(!flag) {
                res = Math.min(res, Math.min(num1 * 10 + nums2[i], nums2[i] * 10 + num1));
            }
        }
        return res;
    }
}
