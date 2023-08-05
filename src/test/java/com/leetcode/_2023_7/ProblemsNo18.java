package com.leetcode._2023_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 18. 四数之和
 *
 * @author DHW
 * @date 2023/7/15 11:20
 * @Version 1.0
*/
public class ProblemsNo18 {

    @Test
    public void solution() {
        int[] numbers = new int[]{1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        System.out.println("res = " + fourSum(numbers, target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long res = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if(res > target) {
                        right--;
                        continue;
                    }else if(res < target) {
                        left++;
                        continue;
                    }
                    while(left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while(left< right && nums[right] == nums[right-1]){
                        right--;
                    }
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(nums[i]);
                    arrayList.add(nums[j]);
                    arrayList.add(nums[left]);
                    arrayList.add(nums[right]);
                    list.add(arrayList);
                    left++;
                    right--;
                }
            }
        }
        return list;
    }

}
