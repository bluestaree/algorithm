package com.leetcode._2025_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 2080. 区间内查询数字的频率
 *
 * @author DHW
 * @date 2025/2/18 9: 43
 * @Version 1.0
*/
public class ProblemsNo2080 {

    @Test
    public void solution() {
        RangeFreqQuery obj = new RangeFreqQuery(new int[]{12,33,4,56,22,2,34,33,22,12,34,56});
        int param_1 = obj.query(0,2,33);
        System.out.println("res = " + param_1);
    }

    class RangeFreqQuery {

        HashMap<Integer, List<Integer>> map = new HashMap();
        public RangeFreqQuery(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                List<Integer> list = map.getOrDefault(arr[i], new ArrayList());
                list.add(i);
                map.put(arr[i], list);
            }
        }

        public int query(int left, int right, int value) {
            if(!map.containsKey(value)) return 0;
            int l = lowerBound(map.get(value), left);
            int r = upperBound(map.get(value), right);
            return r - l;
        }

        private int lowerBound(List<Integer> list, int target) {
            int n = list.size();
            int l = 0;
            int r = n;
            while(l < r) {
                int mid = (l + r) >> 1;
                if(list.get(mid) >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        private int upperBound(List<Integer> list, int target) {
            int n = list.size();
            int l = 0;
            int r = n;
            while(l < r) {
                int mid = (l + r) >> 1;
                if(list.get(mid) <= target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }
}

