package com.leetcode._2024_12;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 1387. 将整数按权重排序
 *
 * @author DHW
 * @date 2024/12/22 10: 40
 * @Version 1.0
*/
public class ProblemsNo1387 {

    @Test
    public void solution() {
        int lo = 12;
        int hi = 15;
        int k = 2;
        System.out.println("res = " + getKth(lo, hi, k));
    }

    private static final Map<Integer, Integer> memo = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        Integer[] nums = new Integer[hi - lo + 1];
        for (int i = lo; i <= hi; i++) {
            nums[i-lo] = i;
        }
        Arrays.sort(nums, (a,b) -> {
            Integer a1 = dfs(a);
            Integer b1 = dfs(b);
            if(a1 == b1) {
                return a - b;
            }else {
                return a1 - b1;
            }
        });
        return nums[k - 1];
    }

    private Integer dfs(Integer i) {
        if (i == 1) {
            return 0;
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        if (i % 2 == 1) {
            memo.put(i, dfs((i * 3 + 1) / 2) + 2);
        } else {
            memo.put(i, dfs(i / 2) + 1);
        }
        return memo.get(i);
    }


//    public int getKth(int lo, int hi, int k) {
//        Integer[] nums = new Integer[hi - lo + 1];
//        Map<Integer, Integer> memo = new HashMap<>();
//        for (int i = lo; i <= hi; i++) {
//            nums[i-lo] = i;
//            memo.put(i, f(i));
//        }
//        Arrays.sort(nums, (a,b) -> {
//            Integer a1 = memo.get(a);
//            Integer b1 = memo.get(b);
//            if(a1 == b1) {
//                return a - b;
//            }else {
//                return a1 - b1;
//            }
//        });
//
//        return nums[k - 1];
//    }
//
//    private Integer f(Integer num) {
//        int res = 0;
//        while(num != 1) {
//            if(num % 2 == 0) {
//                num = num / 2;
//            } else {
//                num = num * 3 + 1;
//            }
//            res++;
//        }
//        return res;
//    }
}

