package com.itheima.week1.linked_list;

import org.junit.Test;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-09-06 15:33
 **/
public class Week1QueueTest {
    @Test
    public void test206反转链表() {
        reverseList(null);
    }
    
    public ListNode reverseList(ListNode head) {
        //初始值判断
        if (head == null || head.next == null) {
            return head;
        }
        //反转链表,需要使用三个变量
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        do {
            next = curr.next;
            
            //转换指针
            curr.next = prev;
            prev = curr;
            curr = next;
        } while (curr != null);
        
        //
        return prev;
    }
    
    @Test
    public void test141环形链表() {
        boolean b = hasCycle(null);
        System.out.println("有没有环:" + b);
    }
    
    public boolean hasCycle(ListNode head) {
        //初始值判断
        if (head == null || head.next == null) {
            return false;
        }
        //通过快慢指针来
        ListNode fast = head;
        ListNode slow = head;
        do {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        } while (fast != null && fast.next != null);
        
        return false;
    }
    
    @Test
    public void test142环形链表II() {
        //输入：1->2->3->4,
        ListNode l14 = new ListNode(4, null);
        ListNode l13 = new ListNode(3, l14);
        ;
        ListNode l12 = new ListNode(2, l13);
        ;
        ListNode l1 = new ListNode(1, l12);
        
        System.out.println(detectCycle(l1));
        
        // 1->3->4
        // ListNode l24 = new ListNode(4, null);
        // ListNode l23 = new ListNode(3, l24);
        // ListNode l2 = new ListNode(2, l23);
        // System.out.println(swapPairs(l2));
    }
    
    public ListNode detectCycle(ListNode head) {
        //初始值判断
        if (head == null || head.next == null) {
            return null;
        }
        //定义快慢指针找到圆的节点数
        ListNode f = head;
        ListNode s = head;
        boolean circle = false;
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
            if (f == s) {
                circle = true;
                break;
            }
        }
        
        if (!circle) {
            return null;
        }
        //走了一圈的距离汇合了
        //需要fast重新走
        //fast和slow每次走相同的步数，直到他们相遇，相遇的结点就
        f = head;
        while (s != f) {
            f = f.next;
            s = s.next;
        }
        return s;
    }
    
    @Test
    public void test2两数相加() {
        //输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        // 输出：7 -> 0 -> 8
        // 原因：342 + 465 = 807S
        ListNode l23 = new ListNode(3, null);
        ListNode l24 = new ListNode(4, l23);
        ListNode l2 = new ListNode(2, l24);
        
        //
        ListNode l14 = new ListNode(4, null);
        ;
        ListNode l16 = new ListNode(6, l14);
        ;
        ListNode l15 = new ListNode(5, l16);
        ;
        System.out.println(addTwoNumbers(l2, l15));
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //    初始值判断
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //构建第三个队列
        ListNode prev = new ListNode(0);
        ListNode l3 = prev;
        
        int up = 0;
        int l1val;
        int l2val;
        do {
            //计算当前位的和
            l1val = l1 == null ? 0 : l1.val;
            l2val = l2 == null ? 0 : l2.val;
            int sum = l1val + l2val + up;
            
            //构建节点
            l3.next = new ListNode(sum % 10);
            //下一轮循环
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            l3 = l3.next;
            up = sum >= 10 ? 1 : 0;
        } while (!(up == 0 && l2 == null && l1 == null));
        
        return prev.next;
    }
    
    @Test
    public void test21合并两个有序链表() {
        //输入：1->2->4,
        ListNode l14 = new ListNode(4, null);
        ;
        ListNode l12 = new ListNode(2, l14);
        ;
        ListNode l1 = new ListNode(1, l12);
        
        // 1->3->4
        ListNode l24 = new ListNode(4, null);
        ListNode l23 = new ListNode(3, l24);
        ListNode l2 = new ListNode(2, l23);
        
        // 输出：1->1->2->3->4->4
        System.out.println(mergeTwoLists(l1, l2));
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //初始值判断
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        //哨兵
        ListNode prev = new ListNode(-1);
        ListNode l3 = prev;
        
        do {
            if (l2.val <= l1.val) {
                l3.next = l2;
                l2 = l2.next;
                l3 = l3.next;
            } else {
                l3.next = l1;
                l1 = l1.next;
                l3 = l3.next;
            }
            
        } while (l2 != null && l1 != null);
        
        if (l2 == null) {
            l3.next = l1;
        } else {
            l3.next = l2;
        }
        return prev.next;
    }
    
    @Test
    public void test24两两交换链表中的节点() {
        //输入：1->2->3->4,
        ListNode l14 = new ListNode(4, null);
        ListNode l13 = new ListNode(3, l14);
        ;
        ListNode l12 = new ListNode(2, l13);
        ;
        ListNode l1 = new ListNode(1, l12);
        
        System.out.println(swapPairs(l1));
        
        // 1->3->4
        // ListNode l24 = new ListNode(4, null);
        // ListNode l23 = new ListNode(3, l24);
        // ListNode l2 = new ListNode(2, l23);
        // System.out.println(swapPairs(l2));
    }
    
    public ListNode swapPairs(ListNode head) {
        //初始值判断
        if (head == null || head.next == null) {
            return head;
        }
        //哨兵
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        
        //初始值
        ListNode prev;
        ListNode curr;
        ListNode next;
        prev = sentinel;
        curr = prev.next;
        next = curr.next;
        while (true) {
            //进行值的互换
            curr.next = next.next;
            next.next = curr;
            prev.next = next;
            
            //下一次循环
            prev = curr;
            curr = curr.next;
            if (curr == null) {
                break;
            }
            next = curr.next;
            if (next == null) {
                break;
            }
        }
        return sentinel.next;
    }
    
    @Test
    public void test3() {
        //输入：1->2->3->4,
        ListNode l14 = new ListNode(4, null);
        ListNode l13 = new ListNode(3, l14);
        ;
        ListNode l12 = new ListNode(2, l13);
        ;
        ListNode l1 = new ListNode(1, l12);
        
        System.out.println(reverseKGroup(l1, 2));
        
        // 1->3->4
        // ListNode l24 = new ListNode(4, null);
        // ListNode l23 = new ListNode(3, l24);
        // ListNode l2 = new ListNode(2, l23);
        // System.out.println(swapPairs(l2));
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        //初始值判断
        if (k <= 1) {
            return head;
        }
        if (head == null) {
            return head;
        }
        //哨兵
        ListNode dump = new ListNode(-1);
        dump.next = head;
        
        ListNode prev = dump;
        ListNode end = dump;
        ListNode next;
        ListNode start;
        o:
        while (true) {
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) {
                    //不足k个退出
                    break o;
                }
            }
            //记录下一个循环的开始节点
            next = end.next;
            //本次的开始
            start = prev.next;
            //反转后
            end.next = null;
            reverse(start);
            prev.next = end;
            start.next = next;
            //下一轮
            prev = start;
            end = start;
        }
        
        //返回值
        return dump.next;
    }
    
    private void reverse(ListNode start) {
        ListNode pre = null;
        ListNode curr = start;
        ListNode next;
        while (curr != null) {
            
            next = curr.next;
            curr.next = pre;
            //下一次循环
            pre = curr;
            curr = next;
        }
    }
}
