package com.leetcode._2024_10;

import org.junit.Test;

import java.util.ArrayDeque;


/**
 * 3175. 找到连续赢 K 场比赛的第一位玩家
 *
 * @author DHW
 * @date 2024/10/24 8:46
 * @Version 1.0
*/
public class ProblemsNo3175 {

    @Test
    public void solution() {
        int[] skills = new int[]{4,8,2,8};
        int k = 0;
        System.out.println("res = " + findWinningPlayer(skills, k));
    }

    public int findWinningPlayer(int[] skills, int k) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int n = skills.length;
        int[] mx = new int[]{0, skills[0]};
        for (int i = 0; i < n; i++) {
            deque.offer(new int[]{i, skills[i]});
            if(mx[1] < skills[i]) {
                mx[0] = i;
                mx[1] = skills[i];
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int[] a = deque.poll();
            if(cnt == k) {
                return a[0];
            }
            int[] b = deque.peek();
            if(a[1] < b[1]) {
                cnt = 1;
                deque.offer(a);
                continue;
            }
            deque.offer(deque.poll());
            deque.addFirst(a);
            cnt++;
        }
        return mx[0];
    }
}

