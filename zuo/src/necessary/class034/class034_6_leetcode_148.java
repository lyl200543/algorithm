package necessary.class034;

/**
 *ClassName: class034_6_leetcode_148
 *Package: necessary.class034
 *Description:创建于 2025/10/2 20:04
 * https://leetcode.cn/problems/sort-list/
 * O(n log n) 时间复杂度和常数级空间复杂度,要求稳定性
 *@Author lyl
 *@Version 1.0
 */
public class class034_6_leetcode_148 {
}

class Solution25 {
    private ListNode start = null;
    private ListNode end = null;

    public ListNode sortList (ListNode head) {
        if (head == null || head.next == null)
            return head;
        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }
        ListNode l1, r1, l2, r2, lastNode, nextNode;
        for (int step = 1 ; step < n ; step = step << 1) {
            //第一组需要特殊处理
            l1 = head;
            r1 = teamEnd(l1 , step);
            l2 = r1.next;
            r2 = teamEnd(l2 , step);
            nextNode = r2.next;
            merge(l1 , r1 , l2 , r2);
            head = start;
            lastNode = end;
            while (nextNode != null) {
                l1 = nextNode;
                r1 = teamEnd(l1 , step);
                l2 = r1.next;
                if (l2 == null) {
                    lastNode.next = l1;
                    break;
                }
                r2 = teamEnd(l2 , step);
                nextNode = r2.next;
                merge(l1 , r1 , l2 , r2);
                lastNode.next = start;
                lastNode = end;
            }
        }
        return head;
    }

    private ListNode teamEnd (ListNode begin , int step) {
        while (begin.next != null && -- step > 0) {
            begin = begin.next;
        }
        return begin;
    }

    private void merge (ListNode l1 , ListNode r1 , ListNode l2 , ListNode r2) {
        r1.next = null;
        r2.next = null;
        ListNode pre = null;
        if (l1.val <= l2.val) {
            start = l1;
            pre = l1;
            l1 = l1.next;
        } else {
            start = l2;
            pre = l2;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            pre.next = l1;
            end = r1;
        } else {
            pre.next = l2;
            end = r2;
        }
    }
}