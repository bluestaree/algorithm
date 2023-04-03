package com.leetcode._2023_3;

import org.junit.Test;


/**
 * 2383. 赢得比赛需要的最少训练时长
 *
 * @author DHW
 * @date 2023/3/13 9:38
 * @Version 1.0
*/
public class ProblemsNo2383 {

    @Test
    public void solution() {
        int initialEnergy = 1;
        int initialExperience = 2;
        int[] energy = new int[]{1,2};
        int[] experience = new int[]{2,3};
        System.out.println("res = " + minNumberOfHours(initialEnergy, initialExperience, energy, experience));
    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int res = 0;
        int energyCount = 0;
        for (int i = 0; i < energy.length; i++) {
            int x = energy[i];
            int y = experience[i];
            energyCount += x;
            if(initialExperience <= y) {
                int sub = y - initialExperience + 1;
                res += sub;
                initialExperience += sub;
            }
            initialExperience += y;
        }
        if(energyCount >= initialEnergy) {
            res += energyCount - initialEnergy + 1;
        }
        return res;
    }

}
