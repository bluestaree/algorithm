package com.leetcode._2026_4;

import org.junit.Test;


/**
 * 2833. 距离原点最远的点
 *
 * @author DHW
 * @date 2026/4/24 8: 38
 * @Version 1.0
 */
public class ProblemsNo2833 {

    @Test
    public void solution() {
        String str = "L_RL__R";
        System.out.println("sortArrayByParity(nums) = " + furthestDistanceFromOrigin(str));
    }

    public int furthestDistanceFromOrigin(String moves) {
        int a = 0, b = 0;
        for (int i = 0; i < moves.length(); i++) {
            if(moves.charAt(i) == 'R') {
                b++;
                a--;
            } else if(moves.charAt(i) == 'L') {
                a++;
                b--;
            }else {
                a++;
                b++;
            }
        }
        return Math.max(a, b);
    }

}

