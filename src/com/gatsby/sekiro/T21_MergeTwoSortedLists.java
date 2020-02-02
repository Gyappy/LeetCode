package com.gatsby.sekiro;

public class T21_MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode result = listNode;

        while (l1 != null || l2 != null) {
            ListNode node;
            if (l1 == null) {
                listNode.next = l2;
                break;
            } else if (l2 == null) {
                listNode.next = l1;
                break;
            }


            listNode.next = new ListNode(Math.min(l1.val, l2.val));
            listNode = listNode.next;

            if (l1.val < l2.val) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        return result.next;
    }
}
