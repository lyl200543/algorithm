import org.junit.Test;

/**
 * ClassName: leetcode_24
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/29 21:18
 *
 * @Author lyl
 * @Version 1.0
 */
public class leetcode_24 {
    @Test
    public void test () {
        Solution3 solution3 = new Solution3();
        ListNode node3 = new ListNode(4 , null);
        ListNode node2 = new ListNode(3 , node3);
        ListNode node1 = new ListNode(2 , node2);
        ListNode head = new ListNode(1 , node1);
        solution3.swapPairs(head);
    }
}

class Solution3 {
    public ListNode swapPairs (ListNode head) {
//        if (head == null || head.next == null)
//            return head;
//        ListNode vNode = new ListNode();
//        vNode.next = head;
//        ListNode pre = vNode;
//        ListNode cur = head;
//        ListNode tmp = cur.next;
//
//        while (cur != null && tmp != null) {
//            cur.next = tmp.next;
//            tmp.next = cur;
//            pre.next = tmp;
//            pre = cur;
//            cur = cur.next;
//            if(cur!=null)
//                tmp = cur.next;
//        }
//        return vNode.next;

        //递归版本：
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        ListNode newNode = swapPairs(next.next);
        next.next = head;
        head.next = newNode;
        return next;
    }
}