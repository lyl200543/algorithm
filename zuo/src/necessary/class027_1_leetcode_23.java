package necessary;

import java.util.PriorityQueue;

/**
 *ClassName: class027_1_leetcode_23
 *Package: necessary
 *Description:创建于 2025/9/13 19:13
 * 合并k个有序链表
 *@Author lyl
 *@Version 1.0
 */
public class class027_1_leetcode_23 {
}

class ListNode {
    int val;
    ListNode next;

    ListNode () {
    }

    ListNode (int val) {
        this.val = val;
    }

    ListNode (int val , ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution6 {
    public ListNode mergeKLists (ListNode[] lists) {
        //默认为小根堆
        PriorityQueue<ListNode> heap = new PriorityQueue<>();
        for (int i = 0 ; i < lists.length ; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode h = heap.poll();
        ListNode p = h;
        while (! heap.isEmpty()) {
            if (p.next != null)
                heap.add(p.next);
            p.next = heap.poll();
            p = p.next;
        }
        return h;

    }
}