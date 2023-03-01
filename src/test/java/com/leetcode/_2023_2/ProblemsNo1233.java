package com.leetcode._2023_2;

import org.junit.Test;

import java.util.*;


/**
 * 1233. 删除子文件夹
 *
 * @author DHW
 * @date 2023/2/8 10:04
 * @Version 1.0
*/
public class ProblemsNo1233 {

    @Test
    public void solution() {
//        String[] folder = new String[]{"/ad","/ad/af","/aa"};
//        String[] folder = new String[]{"/abc/de","/abc/dee","/abc/def","/abc/def/gh","/abc/def/ghi","/abc/def/ghij","/abc/def/ghijk","/abc/dez"};
        String[] folder = new String[]{"/a/b","/c/d","/a","/c/d/e","/c/f"};
        System.out.println("res = " + removeSubfolders(folder));
    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        result.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            StringBuilder sb = new StringBuilder(result.get(result.size() - 1)).append("/");
            if (!folder[i].startsWith(sb.toString())) result.add(folder[i]);
        }
        return result;

//        List<String> res = new ArrayList<>();
//        TreeMap<Integer, Set<String>> map = new TreeMap<>();
//        for (int i = 0; i < folder.length; i++) {
//            String s = folder[i];
//            int lastIndex = s.lastIndexOf("/");
//            Set<String> counts = map.getOrDefault(lastIndex / 2 , new HashSet<>());
//            counts.add(s);
//            map.put(lastIndex / 2 , counts);
//        }
//
//        Set<String> highList = new HashSet<>();
//        for (Map.Entry<Integer, Set<String>> entry : map.entrySet()) {
//            Integer key = entry.getKey();
//            if(key == 0) {
//                highList.addAll(entry.getValue());
//                res.addAll(entry.getValue());
//                continue;
//            }
//            Set<String> lowList = entry.getValue();
//            for (String s : lowList) {
//                boolean flag = false;
//                int formIndex = 1;
//                for (Integer i = 1; i <= key; i++) {
//                    int i1 = s.indexOf("/", formIndex + 1);
//                    if(i1 == -1) {
//                        break;
//                    }
//                    String pre = s.substring(0, i1);
//                    if(highList.contains(pre)) {
//                        flag = true;
//                        break;
//                    }
//                    formIndex = i1;
//                }
//                if(flag) {
//                    continue;
//                }
//                res.add(s);
//            }
//            highList.addAll(lowList);
//        }
//        return res;
    }

}
