package com.leetcode._2025_12;

import org.junit.Test;


/**
 * 2211. 统计道路上的碰撞次数
 *
 * @author DHW
 * @date 2025/12/4 8: 44
 * @Version 1.0
*/
public class ProblemsNo2211 {

    @Test
    public void solution() {
        String s = "RLRSLL";
        System.out.println("res = " + countCollisions(s));
    }

    public int countCollisions(String directions) {
        int ans = 0;
        char[] charArray = directions.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            if(charArray[i] == 'S' && charArray[i - 1] == 'R') {
                ans++;
                continue;
            }
            if(charArray[i] == 'L' && charArray[i - 1] == 'R') {
                ans += 2;
                charArray[i] = 'S';
                continue;
            }
            if(charArray[i] == 'L' && charArray[i - 1] == 'S') {
                ans++;
                charArray[i] = 'S';
                continue;
            }
            if(charArray[i - 1] == 'R') {
                int l = i - 1;
                while (i < charArray.length && charArray[i] == 'R') {
                    i++;
                }
                if(i >= charArray.length) {
                    break;
                }
                ans += i - l;
                if(charArray[i] == 'L') {
                    ans++;
                    charArray[i] = 'S';
                }
            }
        }
        return ans;
    }
}

