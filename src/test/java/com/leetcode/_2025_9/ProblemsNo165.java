package com.leetcode._2025_9;

import org.junit.Test;


/**
 * 165. 比较版本号
 *
 * @author DHW
 * @date 2025/9/23 9: 40
 * @Version 1.0
*/
public class ProblemsNo165 {

    @Test
    public void solution() {
        String version1 = "hello world";
        String version2 = "ad";
        System.out.println("res = " + compareVersion(version1, version2));
    }

    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int len = Math.max(split1.length, split2.length);
        for (int i = 0; i < len; i++) {
            int now1 = i < split1.length ? Integer.parseInt(split1[i]) : 0;
            int now2 = i < split2.length ? Integer.parseInt(split2[i]) : 0;
            if(now1 > now2) {
                return 1;
            } else if(now1 < now2) {
                return -1;
            }
        }
        return 0;
    }
}

