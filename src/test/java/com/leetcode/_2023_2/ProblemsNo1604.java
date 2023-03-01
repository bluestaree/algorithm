package com.leetcode._2023_2;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 1604. 警告一小时内使用相同员工卡大于等于三次的人
 *
 * @author DHW
 * @date 2023/2/7 14:13
 * @Version 1.0
*/
public class ProblemsNo1604 {

    @Test
    public void solution() {
//        String[] keyName = new String[]{"a","a","a","a","a","a","b","b","b","b","b"};
//        String[] keyTime = new String[]{"23:27","03:14","12:57","13:35","13:18","21:58","22:39","10:49","19:37","14:14","10:41"};
        String[] keyName = new String[]{"a","a","a","a","a","b","b","b","b","b","b"};
        String[] keyTime = new String[]{"23:20","11:09","23:30","23:02","15:28","22:57","23:40","03:43","21:55","20:38","00:19"};
        System.out.println("res = " + alertNames(keyName, keyTime));
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> timeMap = new HashMap<String, List<Integer>>();
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            timeMap.putIfAbsent(name, new ArrayList<Integer>());
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            timeMap.get(name).add(hour * 60 + minute);
        }
        List<String> res = new ArrayList<String>();
        Set<String> keySet = timeMap.keySet();
        for (String name : keySet) {
            List<Integer> list = timeMap.get(name);
            Collections.sort(list);
            int size = list.size();
            for (int i = 2; i < size; i++) {
                int time1 = list.get(i - 2), time2 = list.get(i);
                int difference = time2 - time1;
                if (difference <= 60) {
                    res.add(name);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
