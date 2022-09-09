package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 1592. 重新排列单词间的空格
 *
 *
 * @author DHW
 * @date 2022/9/7 8:44
 * @Version 1.0
*/
public class ProblemsNo1592 {

    @Test
    public void solution() {
//        "  this   is  a sentence "
        System.out.println("true = " + reorderSpaces("a"));
    }

    public String reorderSpaces(String text) {
        int spaceCount = 0;
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        char[] chars = text.toCharArray();
        for (int i = 0, len = chars.length; i < len; i++) {
            if(chars[i] == 32) {
                spaceCount += 1;
                if(sb.length() > 0) {
                    list.add(sb.toString());
                    sb.setLength(0);
                }
                continue;
            }
            sb.append(chars[i]);
        }

        if(sb.length() != 0) {
            list.add(sb.toString());
        }

        if(spaceCount == 0) {
            return list.get(0);
        }
        // 单词数
        int words = list.size();

        // 结果集
        StringBuffer stringBuffer = new StringBuffer();
        if(words == 1) {
            stringBuffer.append(list.get(0));
            bulidSpeaceChar(spaceCount, stringBuffer);
            return stringBuffer.toString();
        }

        // 计算每个字符间隔空格数目
        int count = spaceCount / (words - 1);
        // 计算多余空格数量
        int more = spaceCount - count * (words - 1);

        for (int i = 0; i < words - 1; i++) {
            stringBuffer.append(list.get(i));
            bulidSpeaceChar(count, stringBuffer);
        }
        stringBuffer.append(list.get(words-1));
        if(more != 0) {
            bulidSpeaceChar(more, stringBuffer);
        }
        return stringBuffer.toString();
    }

    private void bulidSpeaceChar(int spaceCount, StringBuffer stringBuffer) {
        for (int i = 0; i < spaceCount; i++) {
            stringBuffer.append(" ");
        }
    }
}
