package com.leetcode._2026_9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 624. 数组列表中的最大距离
 *
 * @author DHW
 * @date 2026/9/28 10: 29
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
        int ans = 0;
        int min = Integer.MAX_VALUE / 2;
        int max = Integer.MIN_VALUE / 2;
        for (List<Integer> l : list) {
            int x = l.get(0);
            int y = l.get(l.size() - 1);
            ans = Math.max(ans,  Math.max(y - min, max - x));
            min = Math.min(min, x);
            max = Math.max(max, y);
        }
        return ans;
    }
}

