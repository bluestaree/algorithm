package com.leetcode._2025_12;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


/**
 * 3433. 统计用户被提及情况
 *
 * @author DHW
 * @date 2025/12/12 8: 45
 * @Version 1.0
*/
public class ProblemsNo3433 {

    @Test
    public void solution() {
        int numberOfUsers = 1;
        List<List<String>> events = new ArrayList<>();
        List<String> event1 = new ArrayList<>();
        event1.add("MESSAGE");
        event1.add("10");
        event1.add("id0");
        events.add(event1);
        System.out.println("res = " + countMentions(numberOfUsers, events));
    }

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        Collections.sort(events, (a, b) -> {
            int x = Integer.parseInt(a.get(1));
            int y = Integer.parseInt(b.get(1));
            if(x == y) {
                return a.get(0).charAt(2) - b.get(0).charAt(2);
            }
            return x - y;
        });
        int[] ans = new int[numberOfUsers];
        int[] onlineT = new int[numberOfUsers];
        int count = 0;
        for (List<String> event : events) {
            String etype = event.get(0);
            int cur = Integer.parseInt(event.get(1));
            String s = event.get(2);
            if (etype.charAt(0) == 'O') {
                onlineT[Integer.parseInt(s)] = cur + 60;
            } else if(s.charAt(0) == 'A') {
                count++;
            } else if(s.charAt(0) == 'H') {
                for (int i = 0; i < numberOfUsers; i++) {
                    if(onlineT[i] <= cur) {
                        ans[i]++;
                    }
                }
            } else {
                String[] split = s.split(" ");
                for (String id : split) {
                    ans[Integer.parseInt(id.substring(2))]++;
                }
            }
        }
        if (count > 0) {
            for (int i = 0; i < numberOfUsers; ++i) {
                ans[i] += count;
            }
        }
        return ans;
    }

}

