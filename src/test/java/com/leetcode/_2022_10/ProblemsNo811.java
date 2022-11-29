package com.leetcode._2022_10;

import org.junit.Test;

import java.util.*;


/**
 * 811. 子域名访问计数
 *
 * @author DHW
 * @date 2022/10/5 12:15
 * @Version 1.0
*/
public class ProblemsNo811 {

    @Test
    public void solution() {
        String[] s = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println("subdomainVisits(s) = " + subdomainVisits(s));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        for (String cpdomain : cpdomains) {
            String[] s = cpdomain.split(" ");
            Integer value = Integer.valueOf(s[0]);
            String[] split = s[1].split("\\.");
            for (int i = 0; i < split.length; i++) {
                for (int j = split.length - 1; j >= i ; j--) {
                    sb.insert(0, split[j]);
                    sb.insert(0, ".");
                }
                String res = sb.subSequence(1, sb.length()).toString();
                map.put(res, map.getOrDefault(res, 0) + value);
                sb.delete(0, sb.length());
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getValue());
            sb.append(" ");
            sb.append(entry.getKey());
            list.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return list;
    }
}
