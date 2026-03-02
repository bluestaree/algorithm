package com.leetcode._2026_2;

import org.junit.Test;


/**
 * 1404. 将二进制表示减到 1 的步骤数
 *
 * @author DHW
 * @date 2026/2/26 9: 30
 * @Version 1.0
*/
public class ProblemsNo1404 {

    @Test
    public void solution() {
        String s = "1101";
        System.out.println("res = " + numSteps(s));
    }

    public int numSteps(String s) {
        int ans = 0;
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() > 1) {
            ans++;
            if(sb.charAt(sb.length() - 1) == '0') {
                sb.deleteCharAt(sb.length() - 1);
            }
            else {
                for (int i = sb.length() - 1; i >= 0; i--) {
                    if(sb.charAt(i) == '1') {
                        sb.setCharAt(i, '0');
                        if(i == 0) {
                            sb.insert(0, '1');
                            break;
                        }
                    } else {
                        sb.setCharAt(i, '1');
                        break;
                    }
                }
            }
        }
        return ans;
    }
}

