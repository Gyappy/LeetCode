package com.gatsby.sekiro;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author guchenhui
 * @Describe: 用优先级队列优化
 * @since 2020-05-12
 */
public class T23_MergeKLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode orignal = result;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);

        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null)
            queue.offer(lists[i]);
        }

        while (!queue.isEmpty()) {
            result.next = queue.poll();
            result = result.next;
            if (result.next != null)
                queue.offer(result.next);
        }
        return orignal.next;
    }
}
