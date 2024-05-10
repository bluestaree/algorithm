package com.leetcode._2024_4;

import org.junit.Test;


/**
 * 2739. 总行驶距离
 *
 * @author DHW
 * @date 2024/4/25 9:20
 * @Version 1.0
*/
public class ProblemsNo2739 {

    @Test
    public void solution() {
        int mainTank = 3;
        int additionalTank = 3;
        System.out.println("res = " + distanceTraveled(mainTank, additionalTank));
    }

    public int distanceTraveled(int mainTank, int additionalTank) {
        int res = 0;
        while(mainTank >= 5) {
            mainTank -= 5;
            res += 50;
            if(additionalTank > 0) {
                mainTank++;
                additionalTank--;
            }
        }
        return res + mainTank * 10;
    }


}

