package com.leetcode._2026_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
     * 2080. 区间内查询数字的频率
     *
     * @author DHW
     * @date 2026/7/15 9: 13
     * @Version 1.0
     */
public class ProblemsNo2080 {

    @Test
    public void solution() {
        int[] nums = new int[]{12,33,4,56,22,2,34,33,22,12,34,56};
        RangeFreqQuery r = new RangeFreqQuery(nums);
        r.query(1,2,4);
    }

        class RangeFreqQuery {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            public RangeFreqQuery(int[] arr) {
                for (int i = 0; i < arr.length; i++) {
                    List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
                    list.add(i);
                    map.put(arr[i], list);
                }
            }

            public int query(int left, int right, int value) {
                List<Integer> list = map.getOrDefault(value, new ArrayList<>());
                return search(right + 1, list) - search(left, list);
            }

            private int search(int value, List<Integer> list) {
                int low = 0;
                int high = list.size() - 1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if(list.get(mid) >= value) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                return low;
            }
        }

}

