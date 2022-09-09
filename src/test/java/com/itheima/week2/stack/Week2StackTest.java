package com.itheima.week2.stack;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-09-08 15:57
 **/
public class Week2StackTest {
    @Test
    public void test20有效的括号() {
        String s;
        boolean valid;
        // String s = "()[]{}";
        // boolean valid = isValid(s);
        // System.out.println(valid);
        
        s = "()";
        valid = isValid(s);
        System.out.println(valid);
        
        // String s = "(]";
        // boolean valid = isValid(s);
        // System.out.println(valid);
        
        // String s = "([)]";
        // boolean valid = isValid(s);
        // System.out.println(valid);
        
        // s = "(){}}{";
        // valid = isValid(s);
        // System.out.println(valid);
        //
        // String s = "{[]}";
        // boolean valid = isValid(s);
        // System.out.println(valid);
    }
    
    public boolean isValid(String s) {
        //需要初始值判断
        if (s == null || s.length() < 2) {
            return false;
        }
        //2的倍数才有可能是有效括号
        
        if (s.length() % 2 != 0) {
            return false;
        }
        //缓存
        
        HashMap<Character, Character> cache = new HashMap<>();
        cache.put('(', ')');
        cache.put('[', ']');
        cache.put('{', '}');
        
        //用数组还是用链表来好呢        
        //数组吧
        char[] sarr = s.toCharArray();
        
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : sarr) {
            if (cache.containsKey(c)) {
                //就需要入栈      
                stack.push(c);
            } else if (stack.isEmpty() || cache.get(stack.pop()) != c) {
                return false;
                
            }
        }
        return stack.isEmpty();
    }
    
}
