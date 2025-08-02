package beginning;

/**
 *ClassName: class009_leetcode_206
 *Package: beginning
 *Description:创建于 2025/8/2 21:49
 *@Author lyl
 *@Version 1.0
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode () {
    }

    public ListNode (int val , ListNode next) {
        this.val = val;
        this.next = next;
    }

}

class DoubleListNode {
    int val;
    DoubleListNode next;
    DoubleListNode last;

    public DoubleListNode (int val) {
        this.val = val;
    }
}

public class class009_leetcode_206 {
    //单链表
    public ListNode reverseList (ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //双链表
    public DoubleListNode reverseDoubleList (DoubleListNode head) {
        DoubleListNode next = null;
        DoubleListNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

}
