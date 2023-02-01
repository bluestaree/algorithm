package com.leetcode._2023_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 1807. 替换字符串中的括号内容
 *
 * @author DHW
 * @date 2023/1/12 10:22
 * @Version 1.0
*/
public class ProblemsNo1807 {

    @Test
    public void solution() {
        String s = "(name)is(age)yearsold";
        ArrayList<List<String>> knowledge = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("name");
        list1.add("bob");
        knowledge.add(list1);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("age");
        list2.add("two");
        knowledge.add(list2);

        System.out.println("res = " + evaluate(s, knowledge));
    }

    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        StringBuffer sb = new StringBuffer();
        int fromIndex = 0;
        while(fromIndex < s.length()) {
            int pre = s.indexOf("(", fromIndex);
            if(pre == -1) {
                break;
            }
            int last = s.indexOf(")", fromIndex + 1);
            sb.append(s.substring(fromIndex, pre));
            sb.append(map.getOrDefault(s.substring(pre + 1, last), "?"));
            fromIndex = last + 1;
        }

        return fromIndex < s.length() ? sb.append(s.substring(fromIndex)).toString() : sb.toString();
    }
}
