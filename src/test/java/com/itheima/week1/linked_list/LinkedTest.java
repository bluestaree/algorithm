package com.itheima.week1.linked_list;

import java.util.ArrayList;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-18 17:36
 **/

public class LinkedTest {
    
    public ListNode reverseKGroup1(ListNode head, int k) {
        //
        if (k <= 0) {
            return head;
        }
        //k>n
        //k的长度
        ArrayList<ListNode> klist = new ArrayList<>();
        ListNode sentry0 = new ListNode();
        sentry0.next = head;
        ListNode prev0 = sentry0;
        
        while (true) {
            boolean enough = set2List(prev0, k, klist);
            
            if (!enough) {
                return sentry0.next;
            }
            
            ListNode next = klist.get(k - 1).next;
            
            //翻转
            reverseK(prev0, klist, next);
            
            //获取下一个起点
            prev0 = klist.get(0);
        }
    }
    
    private void reverseK(ListNode prev, ArrayList<ListNode> klist, ListNode next) {
        ListNode tmp = prev;
        int size = klist.size();
        for (int i = size - 1; i >= 0; i--) {
            tmp.next = klist.get(i);
            tmp = klist.get(i);
        }
        tmp.next = next;
    }
    
    private boolean set2List(ListNode tmp, int k, ArrayList<ListNode> klist) {
        klist.clear();
        boolean flag = true;
        for (int i = 1; i <= k; i++) {
            tmp = tmp.next;
            if (tmp == null) {
                // 循环结束 剩下的凑不到k个节点了
                flag = false;
                break;
            }
            klist.add(tmp);
        }
        return flag;
    }
    
}
