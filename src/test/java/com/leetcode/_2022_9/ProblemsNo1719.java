package com.leetcode._2022_9;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.19. 消失的两个数字
 *
 *
 * @author DHW
 * @date 2022/9/26 10:45
 * @Version 1.0
*/
public class ProblemsNo1719 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,3};
        int[] missingTwo = missingTwo(nums);
        for (int i = 0; i < missingTwo.length; i++) {
            System.out.println("i = " + missingTwo[i]);
        }
    }


    public int[] missingTwo(int[] nums) {

        int len = nums.length + 2;
        // 标记数组
        int[] temp = new int[len];

        for (int i = 0; i < nums.length; i++) {
            // 标记当前位置 i-1 数存在
            temp[nums[i]-1] = 1;
        }

        int one = 0;
        int two = 0;
        // 查找
        for (int i = 0; i < temp.length; i++) {
            if(temp[i] == 0) {
                if(one == 0) {
                    one = i + 1;
                } else {
                    two = i + 1;
                    break;
                }
            }
        }

        return new int[]{one, two};
    }
}
