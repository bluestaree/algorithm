package com.leetcode._2023_11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 1410. HTML 实体解析器
 *
 * @author DHW
 * @date 2023/11/23 9:32
 * @Version 1.0
 */
public class ProblemsNo1410 {

    @Test
    public void solution() {
        String text = "x &gt; y &amp;&amp; x &lt; y is always false";
        System.out.println("minimum = " + entityParser(text));
    }

    public String entityParser(String text) {
        HashMap<String, Character> map = new HashMap<>();

        map.put("&quot;", '"');
        map.put("&apos;", '\'');
        map.put("&amp;", '&');
        map.put("&gt;", '>');
        map.put("&lt;", '<');
        map.put("&frasl;", '/');

        StringBuilder sb = new StringBuilder();

        int index = 0;
        while(true) {
            int start = text.indexOf('&', index);
            int end = text.indexOf(';', start + 1);
            if(start < 0 || end < 0) {
                sb.append(text.substring(index));
                break;
            }
            String s = text.substring(start , end + 1);
            Character c = map.get(s);
            if(c != null) {
                sb.append(text.substring(index, start));
                sb.append(c);
                index = end + 1;
            } else {
                sb.append(text.substring(index, start+1));
                index = start + 1;
            }
        }
        return sb.toString();
    }
}