package com.leetcode._2022_9;

import com.itheima.week1.array_list.list.ArrayList;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/**
 * 698. 划分为k个相等的子集
 *
 * @author DHW
 * @date 2022/9/20 10:48
 * @Version 1.0
*/
public class ProblemsNo698 {

    @Test
    public void solution() {
        int[] nums = {4,4,6,2,3,8,10,2,10,7};
        int k = 4;
        System.out.println("true = " + canPartitionKSubsets(nums, k));
    }

    public boolean canPartitionKSubsets1(int[] nums, int k) {
        int length = nums.length;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i] ,0) + 1);
        }

        int partSum = sum / k;

        Arrays.sort(nums);

        int firstIndex = 0;
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            if(firstIndex > i) {
                break;
            }
            if(count > k) {
                return false;
            }
            int otherNum = 0;
            int num2 = nums[i];
            if(map.getOrDefault(num2, 0) == 0) {
                continue;
            }
            // 从后往前遍历 求差值
            otherNum = partSum - num2;
            // 特殊情况，只剩一个未动元素
            if(firstIndex == i) {
                if(otherNum == 0) {
                    return true;
                }
                return false;
            }
            if(otherNum < 0) {
                return false;
            }
            // 满足条件继续
            if(otherNum == 0) {
                count++;
                continue;
            }
            // 两两组合最优解
            if(map.getOrDefault(otherNum, 0) != 0) {
                map.put(otherNum, map.get(otherNum) - 1);
                count++;
                continue;
            }
            // 差值 从前往后求和
            for (int j = firstIndex; j < i; j++) {
                int num1 = nums[j];
                if(map.getOrDefault(num1, 0) == 0) {
                    continue;
                }
                int num = otherNum - num1;
                if(num < 0) {
                    return false;
                }
                if(num == 0) {
                    firstIndex = j + 1;
                    otherNum = 0;
                    break;
                }
                otherNum = num;
            }
            if(otherNum != 0) {
                return false;
            }
            count++;
        }
        if(count > k) {
           return false;
        }
        return true;
    }


    public static int[] numUsed;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        numUsed = new int[nums.length];
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0 || nums[nums.length - 1] > sum / k) return false;
        return divideGroups(nums, nums.length - 1, sum / k, 0, k);
    }

    public boolean divideGroups(int[] nums, int start, int target, int current, int k) {
        if (k == 1) return true; // 分组操作执行k-1次之后，最后剩余的元素，就是最后一组了，不需要再匹配
        if (current == target) return divideGroups(nums, nums.length - 1, target, 0, k - 1); // 分组操作执行k-1次后，最后剩余的元素，就是最后一组了，不需要再匹配
        for (int i = start; i >= 0; i--) {
            if (numUsed[i] == 1 || current + nums[i] > target) continue; // 被使用的元素，不能再次使用；总和大于目标值，也不能使用
            numUsed[i] = 1; // 标记占用
            if (divideGroups(nums, i - 1, target, current + nums[i], k)) return true;
            numUsed[i] = 0; // 撤销标记
            while (i > 0 && nums[i - 1] == nums[i]) i--; // 例如“12333333...”，假如最右侧的“3”这个值没有匹配上，那么它左侧的剩余五个“3”都不需要再匹配了。
        }
        return false;
    }

}
