package com.leetcode._2023_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 1237. 找出给定方程的正整数解
 *
 * @author DHW
 * @date 2023/2/18 11:01
 * @Version 1.0
*/
public class ProblemsNo1237 {

    @Test
    public void solution() {
        CustomFunction function = new CustomFunction() {
            @Override
            public int f(int x, int y) {
                return x + y;
            }
        };
        int z = 0;
        System.out.println("res = " + findSolution(function, z));
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int x = 1; x <= 1000 ; x++) {
            for (int y = 1; y < 1000; y++) {
                if(customfunction.f(x, y) == z) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(x);
                    list.add(y);
                    res.add(list);
                }
            }
        }
        return res;
    }
    
    abstract class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public abstract int f(int x, int y);
    }
}
