package com.leetcode._2025_11;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 717. 1 比特与 2 比特字符
 *
 * @author DHW
 * @date 2025/11/18 8: 43
 * @Version 1.0
*/
public class ProblemsNo717 {

    @Test
    public void solution() {
        int[] bits =  new int[]{1,1,1,0};
        System.out.println("res = " + isOneBitCharacter(bits));
    }

    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if(bits[i] == 1) {
                if(i == bits.length - 2) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

}

