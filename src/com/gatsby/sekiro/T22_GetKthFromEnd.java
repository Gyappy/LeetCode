package com.gatsby.sekiro;

/**
 * @author guchenhui
 * @Describe:双指针基础试题
 * @since 2020-05-14
 */
public class T22_GetKthFromEnd {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode l1 = head, l2 = head;
        for (int i = 0; i < k; i++) {
            l2 = l2.next;
        }
        while (l2 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }

}
