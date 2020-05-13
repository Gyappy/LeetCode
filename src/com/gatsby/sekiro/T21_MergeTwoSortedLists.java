package com.gatsby.sekiro;

public class T21_MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //时间复杂度O(n+m) 空间复杂度O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode f = result;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                f.next = l2;
                break;
            }
            if (l2 == null) {
                f.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                f.next = l1;
                l1 = l1.next;
            } else {
                f.next = l2;
                l2 = l2.next;
            }
            f = f.next;
        }
        return result.next;
    }
}
