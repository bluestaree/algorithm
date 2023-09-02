package com.leetcode._2023_9;

import org.junit.Test;


/**
 * 2511. 最多可以摧毁的敌人城堡数目
 *
 * @author DHW
 * @date 2023/9/2 13:22
 * @Version 1.0
*/
public class ProblemsNo2511 {

    @Test
    public void solution() {
        int[] forts = new int[]{0,0,1,-1};
        System.out.println("res = " + captureForts(forts));
    }

    public int captureForts(int[] forts) {
        int res = 0;
        for (int i = 0,j; i < forts.length - 1;) {
            j = i + 1;
            if(forts[i] != 0) {
                while(j + 1 < forts.length && forts[j] == 0){
                    j++;
                }
                if(forts[i] + forts[j] == 0) {
                    res = Math.max(res, j - i - 1);
                }
            }
            i = j;
        }
        return res;
    }
}
