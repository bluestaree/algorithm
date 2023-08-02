package com.leetcode._2023_7;

import org.junit.Test;

import java.util.Arrays;


/**
 * 771. 宝石与石头
 *
 * @author DHW
 * @date 2023/7/24 9:53
 * @Version 1.0
*/
public class ProblemsNo771 {

    @Test
    public void solution() {
        String jewels = "z";
        String stones = "ZZ";
        System.out.println("res = " + numJewelsInStones(jewels, stones));
    }

    public int numJewelsInStones(String jewels, String stones) {
        int res = 0;
        for(int i = 0; i < stones.length(); i++){
            if(jewels.indexOf(stones.charAt(i)) != -1){
                res++;
            }
        }
        return res;
    }
}
