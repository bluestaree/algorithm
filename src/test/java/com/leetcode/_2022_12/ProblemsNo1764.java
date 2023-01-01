package com.leetcode._2022_12;

import org.junit.Test;


/**
 * 1764. 通过连接另一个数组的子数组得到一个数组
 *
 * @author DHW
 * @date 2022/12/3 9:03
 * @Version 1.0
*/
public class ProblemsNo1764 {

    @Test
    public void solution() {
//        int[][] groups = new int[][]{new int[]{6636698,4693069,-2178984,-2253405,-2732131,8550889,-2324014,-2561263}, new int[]{-8973571,-9146179,7704305,-1063430,-6569826}, new int[]{2791091}, new int[]{-9691134,651171,9835817,4163881,4944714,8166788,-9025553,-9250995,1599781}};
        int[][] groups = new int[][]{new int[]{352529,-4284030,6431387,2432677,-3305342,-4342915,-9007629,3195451,-9587228,5747770,8106556,-2385247,3207013,-8540809,9400364,6852329}, new int[]{9903943}};
        int[] nums = new int[]{-8540809,5747770,2432677,-9587228,3195451,352529,-4284030,6431387,2432677,-3305342,-4342915,-9007629,3195451,-9587228,5747770,8106556,-2385247,3207013,-8540809,-8540809,6852329,-9007629,352529,9903943};
        System.out.println("res = " + canChoose(groups, nums));
    }

    public boolean canChoose(int[][] groups, int[] nums) {
        int count = 0;
        int index = 0;
        for (int i = 0; i < groups.length; i++) {
            int[] group = groups[i];
            for (int j = index; j < nums.length; j++) {
                if(group.length > nums.length - j) {
                    return false;
                }
                if(group[0] == nums[j]) {
                    boolean flag = true;
                    if(group.length > 1) {
                        for (int k = 1,x = j+1; k < group.length && x < nums.length; k++,x++) {
                            if(group[k] != nums[x]) {
                                flag = false;
                                break;
                            }
                        }
                    } else {
                        flag = true;
                    }
                    if(flag) {
                        count ++;
                        index += (j - index + group.length);
                        break;
                    }
                }
            }
        }
        return count == groups.length;
    }
}
