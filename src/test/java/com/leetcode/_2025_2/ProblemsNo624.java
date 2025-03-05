package com.leetcode._2025_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 624. 数组列表中的最大距离
 *
 * @author DHW
 * @date 2025/2/19 10: 29
 * @Version 1.0
*/
public class ProblemsNo624 {

    @Test
    public void solution() {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list.add(list1);
        list.add(list2);
        System.out.println("res = " + maxDistance(list));
    }

    public int maxDistance(List<List<Integer>> list) {
        int res = 0;
        int preMin = list.get(0).get(0);
        int preMax = list.get(0).get(list.get(0).size() - 1);

        for (int i = 1; i < list.size(); i++) {
            int curMin = list.get(i).get(0);
            int curMax = list.get(i).get(list.get(i).size() - 1);

            res = Math.max(res , Math.max(curMax - preMin , preMax - curMin));
            preMin = Math.min(preMin, curMin);
            preMax = Math.max(preMax, curMax);
        }

        return res;
    }
}

