package com.leetcode._2023_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 2178. 拆分成最多数目的正偶数之和
 *
 * @author DHW
 * @date 2023/7/6 9:32
 * @Version 1.0
*/
public class ProblemsNo2178 {

    @Test
    public void solution() {
        long finalSum = 42;
        System.out.println("res = " + maximumEvenSplit(finalSum));
    }

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> list = new ArrayList<>();
        if(finalSum % 2 == 1) {
            return list;
        }

        for (long i = 2; i <= finalSum; i+=2) {
            finalSum = finalSum - i;
            list.add(i);
        }

        if(finalSum != 0) {
            list.add(list.remove(list.size()- 1) + finalSum) ;
        }
        return list;
    }

}
