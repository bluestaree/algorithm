package com.leetcode._2026_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 2452. 距离字典两次编辑以内的单词
 *
 * @author DHW
 * @date 2026/4/22 8: 52
 * @Version 1.0
 */
public class ProblemsNo2452 {

    @Test
    public void solution() {
        String[] queries = new String[]{"note","i","am","leetcode","hello"};
        String[] dictionary = new String[]{"joke","i","am","leetcode","hello"};
        System.out.println("sortArrayByParity(nums) = " + twoEditWords(queries, dictionary));
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int n = queries.length;
        List<String> ans = new ArrayList<String>(n);
        for (String q : queries) {
            for (String s : dictionary) {
                int cnt = 0;
                for (int i = 0; i < s.length() && cnt <= 2; i++) {
                    if (q.charAt(i) != s.charAt(i)) {
                        cnt++;
                    }
                }
                if (cnt <= 2) {
                    ans.add(q);
                    break;
                }
            }
        }
        return ans;
    }

}

