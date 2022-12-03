package com.leetcode._2022_11;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * 791. 自定义字符串排序
 *
 * @author DHW
 * @date 2022/11/6 10:44
 * @Version 1.0
*/
public class ProblemsNo791 {

    @Test
    public void solution() {
        String order = "hucw";
        String s = "utzoampdgkalexslxoqfkdjoczajxtuhqyxvlfatmptqdsochtdzgypsfkgqwbgqbcamdqnqztaqhqanirikahtmalzqjjxtqfnh";
        System.out.println("arr = " + customSortString(order, s));
    }

    public String customSortString(String order, String s) {
        int[] val = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            val[order.charAt(i) - 'a'] = i + 1;
        }
        char[] chars = s.toCharArray();
        Character[] characters = new Character[s.length()];
        for (int i = 0; i < chars.length; i++) {
            characters[i] = chars[i];
        }
        Arrays.sort(characters, (c,x) -> val[c - 'a'] - val[x - 'a']);
        for (int i = 0; i < characters.length; i++) {
            chars[i] = characters[i];
        }
        return new String(chars);
    }

}
