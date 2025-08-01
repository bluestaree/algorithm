package com.leetcode._2025_8;

import org.junit.Test;
import org.junit.runner.Request;

import java.util.ArrayList;
import java.util.List;


/**
 * 118. 杨辉三角
 *
 * @author DHW
 * @date 2025/8/1 8: 55
 * @Version 1.0
*/
public class ProblemsNo118 {

    @Test
    public void solution() {
        int numRows = 6;
        System.out.println("res = " + generate(numRows));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        ans.add(list1);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> pre = ans.get(i - 1);
            int n = i / 2;
            for (int j = 1, k = 0; j < pre.size() &&  k < n; j++, k++) {
                list.add(pre.get(j) + pre.get(j - 1));
            }
            int k =  list.size() - (i +1)% 2 - 1;
            for (; k >= 0; k--) {
                list.add(list.get(k));
            }
            ans.add(list);
        }
        return ans;
    }

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        ans.add(list1);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> pre = ans.get(i - 1);
            for (int j = 1; j < pre.size(); j++) {
                list.add(pre.get(j) + pre.get(j - 1));
            }
            list.add(1);
            ans.add(list);
        }
        return ans;
    }
}

