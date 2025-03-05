package com.leetcode._2025_2;

import org.junit.Test;


/**
 * 2296. 设计一个文本编辑器
 *
 * @author DHW
 * @date 2025/2/27 9: 03
 * @Version 1.0
 */
public class ProblemsNo2296 {

    @Test
    public void solution() {
        TextEditor obj = new TextEditor();
        obj.addText("leetcode");
        int param_1 = obj.deleteText(4);
        obj.addText("practice");
        String param_2 = obj.cursorRight(3);
        String param_3 = obj.cursorLeft(8);
        System.out.println("param_1 = " + param_1);
        System.out.println("param_2 = " + param_3);
    }

    class TextEditor {

        StringBuilder sb;
        int cursor;
        public TextEditor() {
            sb = new StringBuilder();
            cursor = 0;
        }

        public void addText(String text) {
            sb.insert(cursor, text);
            cursor += text.length();
        }

        public int deleteText(int k) {
            if(cursor <= k) {
                int count = cursor;
                sb.replace(0, cursor, "");
                cursor = 0;
                return count;
            }
            sb.replace(cursor - k, cursor, "");
            cursor -= k;
            return k;
        }

        public String cursorLeft(int k) {
            if(cursor < k) {
                cursor = 0;
                return "";
            }
            cursor -= k;
            return cursor >= 10 ? sb.substring(cursor - 10, cursor) : sb.substring(0, cursor);
        }

        public String cursorRight(int k) {
            int length = sb.length();
            if(cursor + k > length) {
                cursor = length;
                return cursor >= 10 ? sb.substring(cursor - 10, cursor) : sb.substring(0, cursor);
            }
            cursor += k;
            return cursor >= 10 ? sb.substring(cursor - 10, cursor) : sb.substring(0, cursor);
        }

    }
}

