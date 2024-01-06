package com.leetcode._2023_12;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 1276. 不浪费原料的汉堡制作方案
 *
 * @author DHW
 * @date 2023/12/25 11:33
 * @Version 1.0
*/
public class ProblemsNo1276 {

    @Test
    public void solution() {
        int tomatoSlices = 7;
        int cheeseSlices = 10;
        System.out.println("res = " + numOfBurgers(tomatoSlices, cheeseSlices));
    }

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int num = tomatoSlices - 2 * cheeseSlices;
        int x = num >> 1;
        int y = cheeseSlices - x;
        List<Integer> res = new ArrayList<>();
        if(num % 2 != 0 || x < 0 || y < 0) {
            return res;
        }
        res.add(x);
        res.add(y);
        return res;
    }
}

