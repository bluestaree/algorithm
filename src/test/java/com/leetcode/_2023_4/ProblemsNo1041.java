package com.leetcode._2023_4;

import org.junit.Test;


/**
 * 1041. 困于环中的机器人
 *
 * @author DHW
 * @date 2023/4/11 11:13
 * @Version 1.0
*/
public class ProblemsNo1041 {

    @Test
    public void solution() {
        String instructions = "LLGRL";
        System.out.println("res = " + isRobotBounded(instructions));
    }

    public boolean isRobotBounded(String instructions) {
        int[] target = new int[2];
        int currentIndex = 1;
        int[] step = new int[]{1, 1, -1, -1};
        int stepIndex = 0;
        char[] chars = instructions.toCharArray();
        for(int i = 0 ; i < 4 ; i++) {
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                if(aChar == 'L') {
                    currentIndex = currentIndex == 0 ? 1 : 0;
                    stepIndex = stepIndex == 0 ? 3 : stepIndex-1;
                } else if(aChar == 'R') {
                    currentIndex = currentIndex == 0 ? 1 : 0;
                    stepIndex = stepIndex == 3 ? 0 : stepIndex+1;
                } else {
                    target[currentIndex] += step[stepIndex];
                }
            }
            if(target[0] == 0 && target[1] == 0) {
                return true;
            }
        }
        return false;
    }
}
