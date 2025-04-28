import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: leetcode_206
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/26 20:58
 *
 * @Author lyl
 * @Version 1.0
 */
public class leetcode_206 {
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution2 {
    public ListNode reverseList (ListNode head) {
//        if (head == null) return head;
//
//        ArrayList<ListNode> list = new ArrayList<>();
//        while (head != null) {
//            list.add(head);
//            head = head.next;
//        }
//        ListNode newNode = list.get(list.size() - 1);
//        for (int i = list.size() - 2 ; i >= 0 ; i--) {
//            ListNode node = list.get(i);
//            list.get(i + 1).next = node;
//        }
//        list.get(0).next = null;
//        return newNode;


        //双指针法：逆转链表的指向
        ListNode pre = head;
        ListNode cur = null;
        while (pre != null) {
            ListNode tmp = cur;
            cur = pre;
            pre = pre.next;

            cur.next =tmp;
        }
        return cur;
    }
}