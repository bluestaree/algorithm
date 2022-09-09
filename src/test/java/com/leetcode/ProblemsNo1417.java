package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 重新格式化字符串
 *
 * @author DHW
 * @date 2022/8/11 15:47
 * @Version 1.0
*/
public class ProblemsNo1417 {

    @Test
    public void solution() {
        System.out.println("result = " + reformat("a0b1c2"));
    }

    public String reformat(String s) {

        // 将字符串转为 char数组
        char[] chars = s.toCharArray();
        // 定义两个集合 分别存储 数字字符 、 字母字符
        ArrayList list1 = new ArrayList<Character>();
        ArrayList list2 = new ArrayList<Character>();
        for (char aChar : chars) {
            if(aChar > '9') {
                list1.add(aChar);
            } else {
                list2.add(aChar);
            }
        }
        // 如果两集合大小差距大于1
        int size1 = list1.size();
        int size2 = list2.size();

        if(Math.abs(size1 - size2) > 1) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        if(size1 > size2) {
            for (int i = 0 ; i < size2; i++) {
                sb.append(list1.get(i));
                sb.append(list2.get(i));
            }
            sb.append(list1.get(size2));
        } else if (size1 == size2) {
            for (int i = 0 ; i < size2; i++) {
                sb.append(list1.get(i));
                sb.append(list2.get(i));
            }
        } else {
            for (int i = 0 ; i < size1; i++) {
                sb.append(list2.get(i));
                sb.append(list1.get(i));
            }
            sb.append(list2.get(size1));
        }


        return sb.toString();
    }
    
}
