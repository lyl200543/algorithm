package necessary.class034;

/**
 *ClassName: class024_2_leetcode_25
 *Package: necessary.class034
 *Description:创建于 2025/9/30 19:53
 *https://leetcode.cn/problems/reverse-nodes-in-k-group/
 *@Author lyl
 *@Version 1.0
 */
public class class024_2_leetcode_25 {
}
class Solution21 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = teamEnd(start, k);
        head = end;
        reverse(start, end);
        ListNode lastTeamNode = start;
        start = lastTeamNode.next;
        end = teamEnd(start, k);
        while (end != null) {
            reverse(start, end);
            //连接前一组和后一组，防止链表断开
            lastTeamNode.next=end;
            lastTeamNode = start;
            start = lastTeamNode.next;
            end = teamEnd(start, k);
        }
        return head;
    }

    private void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null, cur = start, next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    private ListNode teamEnd(ListNode start, int k) {
        ListNode end = start;
        while (--k != 0 && end != null) {
            end = end.next;
        }
        return end;
    }
}