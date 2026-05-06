package com.leetcode._2026_4;

import org.junit.Test;

import javax.swing.plaf.metal.MetalIconFactory;
import java.util.Arrays;
import java.util.Comparator;


/**
 * 522. 最长特殊序列 II
 *
 * @author DHW
 * @date 2026/4/23 10: 44
 * @Version 1.0
 */
public class ProblemsNo522 {

    @Test
    public void solution() {
        String[] strs = new String[]{"aaa","aaa","aa"};
        System.out.println("sortArrayByParity(nums) = " + findLUSlength(strs));
    }

    public int findLUSlength(String[] strs) {
        int ans = -1;
        next:
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() <= ans) { // 不会让 ans 变大
                continue;
            }
            for (int j = 0; j < strs.length; j++) {
                if (j != i && isSubStr(strs[i], strs[j])) {
                    continue next; // 枚举下一个 i
                }
            }
            ans = strs[i].length();
        }
        return ans;
    }

    private boolean isSubStr(String a, String b) {
        int j = 0;
        for (int i = 0; i < b.length(); i++) {
            if(a.charAt(j) == b.charAt(i)) {
                j++;
            }
            if(j == a.length()) {
                return true;
            }
        }
        return false;
    }

}

