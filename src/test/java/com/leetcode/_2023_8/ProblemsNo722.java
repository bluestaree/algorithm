package com.leetcode._2023_8;

import cn.hutool.core.date.format.FastDatePrinter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 722. 删除注释
 *
 * @author DHW
 * @date 2023/8/3 8:54
 * @Version 1.0
*/
public class ProblemsNo722 {

    @Test
    public void solution() {
        String[] source = new String[]{"a/*comment", "line", "more_comment*/b"};
        System.out.println("res = " + removeComments(source));
    }

    public List<String> removeComments(String[] source) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean mark = false;
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if(mark) {
                    if (i + 1 < s.length() && s.charAt(i) == '*' && s.charAt(i + 1) == '/') {
                        mark = false;
                        i++;
                    }
                } else {
                    if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '*') {
                        mark = true;
                        i++;
                    } else if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                        break;
                    } else {
                        sb.append(s.charAt(i));
                    }
                }
            }
            if (!mark && sb.length() > 0) {
                res.add(sb.toString());
                sb.setLength(0);
            }
        }

        return res;
    }
}
