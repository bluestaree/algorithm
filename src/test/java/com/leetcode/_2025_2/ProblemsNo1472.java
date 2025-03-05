package com.leetcode._2025_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 1472. 设计浏览器历史记录
 *
 * @author DHW
 * @date 2025/2/26 9: 08
 * @Version 1.0
 */
public class ProblemsNo1472 {

    @Test
    public void solution() {
        BrowserHistory obj = new BrowserHistory("leetcode.com");
        obj.visit("facebook.com");
        String param_2 = obj.back(1);
        String param_3 = obj.forward(1);
        System.out.println("param_2 = " + param_2);
        System.out.println("param_3 = " + param_3);
    }

    class BrowserHistory {


        Node cur;

        public BrowserHistory(String homepage) {
            cur = new Node(homepage);
        }

        public void visit(String url) {
            Node node = new Node(url);
            cur.next = node;
            node.pre = cur;
            cur = node;
        }

        public String back(int steps) {
            while(steps != 0 && cur.pre != null) {
                cur = cur.pre;
                steps--;
            }
            return cur.val;
        }

        public String forward(int steps) {
            while(steps != 0 && cur.next != null) {
                cur = cur.next;
                steps--;
            }
            return cur.val;
        }

        class Node{
            Node pre;
            Node next;
            String val;

            public Node getPre() {
                return pre;
            }

            public void setPre(Node pre) {
                this.pre = pre;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public String getVal() {
                return val;
            }

            public void setVal(String val) {
                this.val = val;
            }

            public Node() {
            }

            public Node(String val) {
                this.val = val;
            }
        }

    }
}

