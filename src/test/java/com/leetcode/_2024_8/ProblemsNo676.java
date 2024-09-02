package com.leetcode._2024_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * 676. 实现一个魔法字典
 *
 * @author DHW
 * @date 2024/8/12 9:00
 * @Version 1.0
*/
public class ProblemsNo676 {

    @Test
    public void solution() {
        MagicDictionary obj = new MagicDictionary();
        String[] dictionary = new String[]{"hello", "leetcode"};
        obj.buildDict(dictionary);
        boolean param_2 = obj.search("searchWord");
        System.out.println("res = " + param_2);
    }

    class MagicDictionary {

        private HashMap<Integer, List<String>> map = new HashMap<>();

        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) {
                List<String> list = map.getOrDefault(s.length(), new ArrayList<>());
                list.add(s);
                map.put(s.length(), list);
            }
        }

        public boolean search(String searchWord) {
            int len = searchWord.length();
            List<String> list = map.get(searchWord.length());
            if(list == null) {
                return false;
            }
            for (String s : list) {
                int cnt = 0;
                for (int i = 0; i < len; i++) {
                    if(s.charAt(i) != searchWord.charAt(i)) {
                        cnt++;
                    }
                }
                if(cnt == 1) {
                    return true;
                }
            }
            return false;
        }
    }
}

