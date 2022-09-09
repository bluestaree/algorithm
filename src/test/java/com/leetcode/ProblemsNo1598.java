package com.leetcode;

import org.junit.Test;


/**
 * 1598. 文件夹操作日志搜集器
 *
 *
 * @author DHW
 * @date 2022/9/9 10:49
 * @Version 1.0
*/
public class ProblemsNo1598 {

    @Test
    public void solution() {
        System.out.println("true = " + minOperations(new String[]{"d1/","d2/","./","d3/","../","d31/"}));
    }

    public int minOperations(String[] logs) {
        int depth = 0;
        for (int i = 0; i < logs.length; i++) {
            String oper = logs[i];
            switch (oper) {
                case "../" :
                    if(depth != 0) {
                        depth -= 1;
                    }
                    break;
                case "./" :
                    break;
                default:
                    depth += 1;
                    break;
            }
        }
        return depth;
    }
}
