package com.leetcode._2022_10;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 915. 分割数组
 *
 * @author DHW
 * @date 2022/10/13 9:30
 * @Version 1.0
*/
public class ProblemsNo915 {

    @Test
    public void solution() {
        int[] arr = new int[]{5,8,3,8,9,3,10};
        System.out.println("arr = " + partitionDisjoint(arr));
    }

    public int partitionDisjoint(int[] nums) {
        int indexA = 0;
        int indexB = 0;
        for (int i = 1; i < nums.length; i++) {
            if(indexB != 0) {
                if(nums[indexB] > nums[i]) {
                    indexB = i;
                }
            } else {
                if(nums[indexA] < nums[i]) {
                    if(indexB == 0) {
                        indexB = i;
                    }
                }
            }

        }
        return 0;
    }

}
