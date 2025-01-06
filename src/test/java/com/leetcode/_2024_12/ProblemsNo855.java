package com.leetcode._2024_12;

import org.junit.Test;

import java.util.*;


/**
 * 855. 考场就座
 *
 * @author DHW
 * @date 2024/12/23 9: 46
 * @Version 1.0
*/
public class ProblemsNo855 {

    @Test
    public void solution() {
        ExamRoom obj = new ExamRoom(10);
        int param_1 = obj.seat();
        obj.leave(4);
    }

    class ExamRoom {

        private TreeSet<int[]> ts = new TreeSet<>((a,b) -> {
            int d1 = dist(a);
            int d2 = dist(b);
            return d1 == d2 ? a[0] - b[0] : d2 - d1;
        });
        private Map<Integer, Integer> left = new HashMap<>();
        private Map<Integer, Integer> right = new HashMap<>();
        private int n;

        public ExamRoom(int n) {
            this.n = n;
            add(new int[]{-1, n});
        }

        public int seat() {
            int[] s = ts.first();
            int p = (s[0] + s[1]) >> 1;
            if(s[0] == -1) {
                p = 0;
            } else if(s[1] == n) {
                p = n - 1;
            }
            remove(s);
            add(new int[]{s[0], p});
            add(new int[]{p, s[1]});
            return p;
        }

        public void leave(int p) {
            Integer l = left.get(p);
            Integer r = right.get(p);
            remove(new int[]{l, p});
            remove(new int[]{p, r});
            add(new int[]{l, r});
        }

        public void add(int[] s) {
            ts.add(s);
            left.put(s[1], s[0]);
            right.put(s[0], s[1]);
        }

        public void remove(int[] s) {
            ts.remove(s);
            left.remove(s[1]);
            right.remove(s[0]);
        }

        public int dist(int[] s) {
            int l = s[0];
            int r = s[1];
            return r == n || l == -1 ? r - l - 1 : (r - l) >> 1;
        }
    }
}

