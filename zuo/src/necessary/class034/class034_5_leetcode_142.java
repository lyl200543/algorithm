package necessary.class034;

/**
 *ClassName: class034_5_leetcode_142
 *Package: necessary.class034
 *Description:创建于 2025/10/2 19:47
 *https://leetcode.cn/problems/linked-list-cycle-ii/
 *@Author lyl
 *@Version 1.0
 */
public class class034_5_leetcode_142 {
}

class Solution24 {
    public ListNode detectCycle (ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                fast=head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}