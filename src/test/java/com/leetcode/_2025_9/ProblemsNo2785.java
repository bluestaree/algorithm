package com.leetcode._2025_9;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;


/**
 * 2785. 将字符串中的元音字母排序
 *
 * @author DHW
 * @date 2025/9/11 8: 51
 * @Version 1.0
*/
public class ProblemsNo2785 {

    @Test
    public void solution() {
        String s = "cdbcbbaaabab";
        System.out.println("res = " + sortVowels(s));
    }

    public String sortVowels(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Character> clist = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                list.add(i);
                clist.add(s.charAt(i));
            }
        }
        Collections.sort(clist);
        char[] charArray = s.toCharArray();
        for (int i = 0; i < list.size(); i++) {
            charArray[list.get(i)] = clist.get(i);
        }
        return String.valueOf(charArray);
    }
}

