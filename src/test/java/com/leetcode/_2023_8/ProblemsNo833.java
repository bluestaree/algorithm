package com.leetcode._2023_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * 833. 字符串中的查找与替换
 *
 * @author DHW
 * @date 2023/8/15 9:24
 * @Version 1.0
*/
public class ProblemsNo833 {

    @Test
    public void solution() {
        String s = "abcd";
        int[] indices = new int[]{0, 2};
        String[] sources = new String[]{"a", "cd"};
        String[] targets = new String[]{"eee", "ffff"};
        System.out.println("res = " + findReplaceString(s, indices, sources, targets));
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder(s);
        int offset = 0;
        int length, start, end;
        String temp;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < indices.length; i++) {
            list.add(i);
        }
        list.sort((i, j) -> indices[i] - indices[j]);
        for (int i = 0; i < sources.length; i++) {
            Integer index = list.get(i);
            String source = sources[index];
            length = source.length();
            start = indices[index] + offset;
            end = start + length;
            if(end > sb.length()) {
                continue;
            }
            temp = sb.substring(start, end);
            if(source.equals(temp)) {
                sb.replace(start, end, targets[index]);
                offset = offset + targets[index].length() - temp.length();
            }
        }
        return sb.toString();
    }
}
