package com.gatsby.sekiro;

/**
 * @author guchenhui
 * @Describe:
 * @since 2020-05-11
 */
public class T142_DetectCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        boolean isCycle = false;
        ListNode l1, l2;
        l1 = head;
        l2 = head;
        while (l2 != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next.next;
            if (l1 == l2) {
                isCycle = true;
                break;
            }
        }
        if (isCycle) {
            while (head != l1) {
                l1 = l1.next;
                head = head.next;
            }
            return head;
        } else {
            return null;
        }
    }
}
