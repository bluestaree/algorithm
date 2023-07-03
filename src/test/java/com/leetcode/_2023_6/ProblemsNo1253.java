package com.leetcode._2023_6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 1253. 重构 2 行二进制矩阵
 *
 * @author DHW
 * @date 2023/6/29 9:07
 * @Version 1.0
*/
public class ProblemsNo1253 {

    @Test
    public void solution() {
        int upper = 5;
        int lower = 5;
        int[] queries = new int[]{2,1,2,0,1,0,1,2,0,1};
        System.out.println("res = " + reconstructMatrix(upper, lower, queries));
    }

    public List<List<Integer>> reconstructMatrix1(int upper, int lower, int[] colsum) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        List<Integer> upperList = new ArrayList<>();
        List<Integer> lowerList = new ArrayList<>();

        boolean firstUpper = upper >= lower;
        for (int i = 0; i < colsum.length; i++) {
            if(colsum[i] == 0) {
                continue;
            }
            int upperNum = 0;
            int lowerNum = 0;

            if(firstUpper && upper > 0) {
                upper -= 1;
                upperNum += 1;
            } else if(lower > 0) {
                lower -= 1;
                lowerNum += 1;
            } else if(upper > 0) {
                upper -= 1;
                upperNum += 1;
            } else {
                return list;
            }
            if(colsum[i] == 2) {
                if(firstUpper && lower > 0) {
                    lower -= 1;
                    lowerNum += 1;
                } else if(upper > 0) {
                    upper -= 1;
                    upperNum += 1;
                } else if(lower > 0) {
                    lower -= 1;
                    lowerNum += 1;
                } else {
                    return list;
                }
            }
            upperList.add(upperNum);
            lowerList.add(lowerNum);
        }
        list.add(upperList);
        list.add(lowerList);
        return list;
    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        List<Integer> upperList = new ArrayList<>();
        List<Integer> lowerList = new ArrayList<>();

        for (int i = 0; i < colsum.length; i++) {
            int upperNum = 0;
            int lowerNum = 0;
            if(colsum[i] == 2) {
                if(upper > 0 && lower > 0) {
                    upper -= 1;
                    upperNum += 1;
                    lower -= 1;
                    lowerNum += 1;
                } else {
                    return list;
                }
            } else if (colsum[i] == 1) {
                if(upper > 0 && upper >= lower) {
                    upper -= 1;
                    upperNum += 1;
                } else if(lower > 0) {
                    lower -= 1;
                    lowerNum += 1;
                } else {
                    return list;
                }
            }
            upperList.add(upperNum);
            lowerList.add(lowerNum);
        }
        if(lower + upper == 0) {
            list.add(upperList);
            list.add(lowerList);
        }
        return list;
    }
}
