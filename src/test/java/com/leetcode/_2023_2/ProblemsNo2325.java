package com.leetcode._2023_2;

import org.junit.Test;

import java.util.HashMap;


/**
 * 2325. 解密消息
 *
 * @author DHW
 * @date 2023/2/1 15:01
 * @Version 1.0
*/
public class ProblemsNo2325 {

    @Test
    public void solution() {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        System.out.println("res = " + decodeMessage(key, message));
    }

    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();
        char[] keyChars = key.toCharArray();
        char nowChar = 'a';
        for (int i = 0; i < keyChars.length; i++) {
            if(Character.isSpaceChar(keyChars[i]) ||  map.containsKey(keyChars[i])) {
                continue;
            }
            map.put(keyChars[i], nowChar++);
        }
        char[] result = new char[message.length()];
        char[] codeChars = message.toCharArray();
        for (int i = 0; i < codeChars.length; i++) {
            if(Character.isSpaceChar(codeChars[i])) {
                result[i] = codeChars[i];
                continue;
            }
            result[i] = map.get(codeChars[i]);
        }
        return new String(result);
    }
}
