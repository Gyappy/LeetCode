package com.gatsby.sekiro;

/**
 * @author guchenhui
 * @Describe: 非常恶心的递归模拟，需要处理一些边界情况，难度绝对不到medium
 *            改用双指针方案 会简单很多
 * @since 2020-05-13
 */
public class T19_RemoveNthFromEnd {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    int count;
    ListNode sw;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next != null)
            removeNthFromEnd(head.next, n);
        if (head.next == null) {
            count++;
            if (count == n) {
                sw = head.next;
                head.next = null;
            }
        } else {
            if (count == n) {
                sw = head.next;
                head.next = null;
            }

            if (count - n == 1) {
                head.next = sw;
            }
            count++;
        }


        return head == null ? head.next : head;
    }
}
