package com.leetcode._2026_9;

import org.junit.Test;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 2861. 最大合金数
 *
 * @author DHW
 * @date 2026/9/1 9: 35
 * @Version 1.0
 */
public class ProblemsNo2861 {

    @Test
    public void solution() {
        List<List<Integer>> composition = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        list1.add(1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        list2.add(10);
        composition.add(list1);
        composition.add(list2);
        ArrayList<Integer> stock = new ArrayList<>();
        stock.add(0);
        stock.add(0);
        stock.add(0);
        ArrayList<Integer> cost = new ArrayList<>();
        cost.add(1);
        cost.add(2);
        cost.add(3);
        System.out.println("= res = " + maxNumberOfAlloys(3, 2, 15, composition, stock, cost));
    }

    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int mx = Collections.min(stock) + budget;
        Integer[] stocks = stock.toArray(new Integer[]{});
        Integer[] costs = cost.toArray(new Integer[]{});

        int ans = 0;
        for (List<Integer> integers : composition) {
            Integer[] array = integers.toArray(new Integer[]{});
            int left = ans;
            int right = mx;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long totalCost = 0;
                for (int i = 0; i < n && totalCost <= budget; i++) {
                    long need = (long) array[i] * mid - stocks[i];
                    if (need > 0) {
                        totalCost += need * costs[i];
                    }
                }
                if (totalCost <= budget) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            ans = Math.max(ans, right);
        }
        return ans;
    }
}

