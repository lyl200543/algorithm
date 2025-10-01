package necessary.class034;

import java.util.List;

/**
 *ClassName: class034_4_leetcode_234
 *Package: necessary.class034
 *Description:创建于 2025/10/1 19:55
 * https://leetcode.cn/problems/palindrome-linked-list/
 *@Author lyl
 *@Version 1.0
 */
public class class034_4_leetcode_234 {
}

class Solution23 {
    public boolean isPalindrome (ListNode head) {
        if (head.next == null)
            return true;
        //快慢指针找中点
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //右半部分倒置
        ListNode p = reverse(slow , slow.next , null);
        slow.next = null;
        //判断是否为回文
        boolean ret = true;
        ListNode h = head;
        while (h != null && p != null) {
            if (h.val != p.val)
                ret = false;
            h = h.next;
            p = p.next;
        }
        //恢复链表
        reverse(null , p , null);
        return ret;
    }

    private static ListNode reverse (ListNode pre , ListNode cur , ListNode next) {
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}