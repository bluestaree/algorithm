package com.leetcode._2023_11;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;


/**
 * 1670. 设计前中后队列
 *
 * @author DHW
 * @date 2023/11/28 9:08
 * @Version 1.0
*/
public class ProblemsNo1670 {

    @Test
    public void solution() {

        FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
        obj.pushFront(1);
        obj.pushMiddle(2);
        obj.pushBack(3);
        int param_4 = obj.popFront();
        System.out.println("param_4 = " + param_4);
        int param_5 = obj.popMiddle();
        System.out.println("param_5 = " + param_5);
        int param_6 = obj.popBack();
        System.out.println("param_6 = " + param_6);
    }

    class FrontMiddleBackQueue {
        private Deque<Integer> fronDeque;
        private Deque<Integer> backDeque;


        public FrontMiddleBackQueue() {
            fronDeque = new ArrayDeque<>();
            backDeque = new ArrayDeque<>();
        }

        public void pushFront(int val) {
            fronDeque.offerFirst(val);
            reBalance();
        }


        public void pushMiddle(int val) {
            fronDeque.offerLast(val);
            reBalance();
        }

        public void pushBack(int val) {
            backDeque.offerLast(val);
            reBalance();
        }

        public int popFront() {
            if(fronDeque.size() == 0 && backDeque.size() == 0) {
               return -1;
            }
            Integer res = fronDeque.isEmpty() ? backDeque.pollFirst() : fronDeque.pollFirst();
            reBalance();
            return res;

        }

        public int popMiddle() {
            if(fronDeque.size() == 0 && backDeque.size() == 0) {
                return -1;
            }
            Integer res = fronDeque.size() == backDeque.size() ? fronDeque.pollLast() : backDeque.pollFirst();
            reBalance();
            return res;
        }

        public int popBack() {
            if(backDeque.size() == 0) {
                return -1;
            }
            Integer res = backDeque.pollLast();
            reBalance();
            return res;
        }

        private void reBalance() {
            if(fronDeque.size() > backDeque.size()) {
                backDeque.offerFirst(fronDeque.pollLast());
            }
            if(backDeque.size() > fronDeque.size() + 1) {
                fronDeque.offerLast(backDeque.pollFirst());
            }
        }

    }
}

