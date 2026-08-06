package com.leetcode._2026_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 1146. 快照数组
 *
 * @author DHW
 * @date 2026/7/28 9: 29
 * @Version 1.0
 */
public class ProblemsNo1146 {

    @Test
    public void solution() {
        SnapshotArray obj = new SnapshotArray(1);
        obj.set(0,4);
        obj.set(0,16);
        obj.set(0,13);
        int param_2 = obj.snap();
        int param_3 = obj.get(0,0);
    }

    class SnapshotArray {
        private List<int[]>[] arr;
        private int idx;

        public SnapshotArray(int length) {
            arr = new List[length];
            for (int i = 0; i < length; i++) {
                arr[i] = new ArrayList<>();
            }
        }

        public void set(int index, int val) {
            arr[index].add(new int[]{idx, val});
        }

        public int snap() {
            return idx++;
        }

        public int get(int index, int snap_id) {
            List<int[]> list = arr[index];
            int l = 0, r = list.size() - 1;
            while(l <= r) {
                int mid = l + (r - l) / 2;
                if(list.get(mid)[0] <= snap_id) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            l--;
            return l < 0 ? 0 : list.get(l)[1];
        }
    }

}

