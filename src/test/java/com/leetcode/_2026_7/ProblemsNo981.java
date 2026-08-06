package com.leetcode._2026_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 981. 基于时间的键值存储
 *
 * @author DHW
 * @date 2026/7/29 9: 29
 * @Version 1.0
 */
public class ProblemsNo981 {

    @Test
    public void solution() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // 存储键 "foo" 和值 "bar" ，时间戳 timestamp = 1
        timeMap.get("foo", 1);         // 返回 "bar"
        timeMap.get("foo", 3);         // 返回 "bar", 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"） 。
        timeMap.set("foo", "bar2", 4); // 存储键 "foo" 和值 "bar2" ，时间戳 timestamp = 4
        timeMap.get("foo", 4);         // 返回 "bar2"
        timeMap.get("foo", 5);         // 返回 "bar2"
    }

    class TimeMap {
        Map<String, List<String[]>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            List<String[]> list = map.getOrDefault(key, new ArrayList<>());
            list.add(new String[]{value, timestamp + ""});
            map.put(key, list);
        }

        public String get(String key, int timestamp) {
            List<String[]> list = map.getOrDefault(key, new ArrayList<>());
            int l = 0;
            int r = list.size() - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                String s = list.get(mid)[1];
                if (Integer.parseInt(s) <= timestamp) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            l--;
            return l < 0 ? "" : list.get(l)[0];
        }
    }

}

