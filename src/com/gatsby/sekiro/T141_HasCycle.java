package com.gatsby.sekiro;

/**
 * @author guchenhui
 * @Describe: 判断链表是否成环 快慢指针
 * @since 2020-05-11
 */
public class T141_HasCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode l1, l2;
        l1 = head;
        l2 = head;
        while (l2 != null && l2.next != null) {
            l1=l1.next;
            l2=l2.next.next;
            if(l1==l2){
                return true;
            }
        }
        return false;
    }
}
