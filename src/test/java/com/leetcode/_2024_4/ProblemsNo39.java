package com.leetcode._2024_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;


/**
 * 39. 组合总和
 *
 * @author DHW
 * @date 2024/4/20 9:57
 * @Version 1.0
*/
public class ProblemsNo39 {

    @Test
    public void solution() {
        int target = 1;
        int[] candidates = new int[]{4,2,1};
        System.out.println("res = " + combinationSum(candidates, target));
    }

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        dfs(0, target);
        return ans;
    }

    private void dfs(int i, int s) {
        if(s == i) {
            ans.add(new ArrayList<>(t));
            return;
        }
        if(s < candidates[i]) {
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            t.add(candidates[i]);
            dfs(j, s - candidates[i]);
            t.remove(t.size() - 1);
        }
    }
}

