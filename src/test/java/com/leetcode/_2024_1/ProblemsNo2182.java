package com.leetcode._2024_1;

import com.sun.javafx.scene.traversal.ContainerTabOrder;
import org.junit.Test;

import java.util.Arrays;


/**
 * 2182. 构造限制重复的字符串
 *
 * @author DHW
 * @date 2024/1/13 20:52
 * @Version 1.0
*/
public class ProblemsNo2182 {

    @Test
    public void solution() {
        String s = "robnsdvpuxbapuqgopqvxdrchivlifeepy";
        int repeatLimit = 2;
        System.out.println("res = " + repeatLimitedString(s, repeatLimit));
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        char pre = chars[chars.length - 1];
        sb.append(pre);
        int num = 1;
        int index = 0;
        for (int i = chars.length - 2; i >= 0; i--) {
            if(chars[i] == '0') {
                continue;
            }
            if(chars[i] == pre) {
                if(num == repeatLimit) {
                    if(index == 0 || index >= i) {
                       index = i - 1;
                    }
                    for (int j = index; j >= 0 ; j--) {
                        if(chars[j] != '0' && chars[i] != chars[j]) {
                            sb.append(chars[j]);
                            pre = chars[j];
                            chars[j] = '0';
                            index = j - 1;
                            break;
                        }
                    }
                    if(pre != chars[i]) {
                        num = 1;
                        i++;
                        continue;
                    }else {
                        return sb.toString();
                    }
                } else {
                    num++;
                }
            } else {
                num = 1;
                pre = chars[i];
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}

