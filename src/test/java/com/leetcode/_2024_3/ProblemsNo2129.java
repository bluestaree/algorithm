package com.leetcode._2024_3;

import org.junit.Test;


/**
 * 2129. 将标题首字母大写
 *
 * @author DHW
 * @date 2024/3/11 9:45
 * @Version 1.0
*/
public class ProblemsNo2129 {

    @Test
    public void solution() {
        String title = "6244988279";
        System.out.println("res = " + capitalizeTitle(title));
    }

    public String capitalizeTitle(String title) {
        StringBuffer sb = new StringBuffer();
        String[] split = title.split(" ");
        for (String s : split) {
            if(s.length() <= 2) {
                sb.append(s.toLowerCase());
            } else {
                sb.append(s.substring(0, 1).toUpperCase());
                sb.append(s.substring(1).toLowerCase());
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}

