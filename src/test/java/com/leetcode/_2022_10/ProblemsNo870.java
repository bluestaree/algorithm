package com.leetcode._2022_10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * 870. 优势洗牌
 *
 * @author DHW
 * @date 2022/10/8 10:39
 * @Version 1.0
*/
public class ProblemsNo870 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{12,24,8,32};
        int[] nums2 = new int[]{13,25,32,11};
        int[] nums3 = advantageCount(nums1, nums2);
        for (int i = 0; i < nums3.length; i++) {
            System.out.println(nums3[i]);
        }
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        Integer[] orderPos = new Integer[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            orderPos[i] = i;
        }
        Arrays.sort(nums1);
        Arrays.sort(orderPos, Comparator.comparingInt(c->nums2[c]));

        int head = 0; int tail = orderPos.length - 1;
        for (int i = orderPos.length - 1; i >= 0; i--) {
            if(nums1[tail] > nums2[orderPos[i]]) {
                nums2[orderPos[i]] = nums1[tail--];
            } else {
                nums2[orderPos[i]] = nums1[head++];
            }
        }

        return nums2;
    }

    private int[] searchAndChange(int beginIndex, int target, int[] nums1) {
        int expectIndex = -1;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = beginIndex; i < nums1.length; i++) {
            if(nums1[i] > target) {
                if(expectIndex == -1 || nums1[i] < nums1[expectIndex]) {
                    expectIndex = i;
                }
            }
            if(nums1[i] < min) {
                min = nums1[i];
                minIndex = i;
            }
        }
        if(expectIndex == -1) {
            swap(beginIndex, minIndex, nums1);
        } else {
            swap(beginIndex, expectIndex, nums1);
        }
        return nums1;
    }

    private void swap(int beginIndex, int expectIndex, int[] nums1) {
        int temp = nums1[beginIndex];
        nums1[beginIndex] = nums1[expectIndex];
        nums1[expectIndex] = temp;
    }

}
