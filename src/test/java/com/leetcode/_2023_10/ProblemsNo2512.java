package com.leetcode._2023_10;

import org.junit.Test;

import java.util.*;


/**
 * 2512. 奖励最顶尖的 K 名学生
 *
 * @author DHW
 * @date 2023/10/11 9:17
 * @Version 1.0
*/
public class ProblemsNo2512 {

    @Test
    public void solution() {
        String[] positive_feedback = new String[]{"smart","brilliant","studious"};
        String[] negative_feedback = new String[]{"not"};
        String[] report = new String[]{"this student is studious","the student is smart"};
        int[] student_id  = new int[]{1,2};
        int k = 2;
        System.out.println("res = " + topStudents(positive_feedback, negative_feedback, report, student_id, k));
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        HashSet<String> p = new HashSet<>();
        HashSet<String> n = new HashSet<>();
        for (int i = 0; i < positive_feedback.length; i++) {
            p.add(positive_feedback[i]);
        }
        for (int i = 0; i < negative_feedback.length; i++) {
            n.add(negative_feedback[i]);
        }

        int len = report.length;
        int[][] scopes = new int[len][2];
        for (int i = 0; i < len; i++) {
            String[] split = report[i].split(" ");
            scopes[i][0] = student_id[i];
            for (int j = 0; j < split.length; j++) {
                if(p.contains(split[j])) {
                    scopes[i][1] += 3;
                } else if(n.contains(split[j])) {
                    scopes[i][1] -= 1;
                }
            }
        }

        Arrays.sort(scopes, (x,y) -> x[1] == y[1] ? x[0] - y[0] : y[1] - x[1]);

        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            res.add(scopes[i][0]);
        }
        return res;
    }
}

