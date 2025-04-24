/**
 * ClassName: leetcode_203
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/23 20:57
 *
 * @Author lyl
 * @Version 1.0
 */
public class leetcode_203 {

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

class Solution {
    public ListNode removeElements (ListNode head , int val) {
        ListNode node = new ListNode();
        node.next = head;
        ListNode newhead = node;
        if (head != null) {
            while (node.next != null) {
                if (node.next.val == val)
                    node.next = node.next.next;
                else
                    node = node.next;
            }
        }
        return newhead.next;
    }
}