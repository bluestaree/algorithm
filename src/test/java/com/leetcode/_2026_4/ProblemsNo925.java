package com.leetcode._2026_4;

import org.junit.Test;


/**
 * 925. 长按键入
 *
 * @author DHW
 * @date 2026/4/9 9: 52
 * @Version 1.0
 */
public class ProblemsNo925 {

    @Test
    public void solution() {
        String name = "cat and mice";
        String typed = "cat and mice";
        System.out.println("res = " + isLongPressedName(name, typed));
    }

    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        for (; j < typed.length(); j++) {
            if(typed.charAt(j) != name.charAt(i - 1)) {
                return false;
            }
        }
        return i == name.length();
    }
}

