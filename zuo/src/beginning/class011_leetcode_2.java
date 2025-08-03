package beginning;

/**
 *ClassName: class011_leetcode_2
 *Package: beginning
 *Description:创建于 2025/8/3 21:50
 *@Author lyl
 *@Version 1.0
 */
public class class011_leetcode_2 {
}

class Solution1 {
    public ListNode addTwoNumbers (ListNode l1 , ListNode l2) {
        // ListNode head = l1;
        // while (l1 != null && l2 != null) {
        //     int val = l1.val + l2.val;
        //     l1.val = val % 10;
        //     l1 = l1.next;
        //     l2=l2.next;
        //     l1.val = li.val + val / 10;
        // }
        // while(l1!=null){

        // }
        // return head;

        StringBuilder v1 = new StringBuilder("");
        StringBuilder v2 = new StringBuilder("");
        while (l1 != null) {
            v1 = v1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            v2 = v2.append(l2.val);
            l2 = l2.next;
        }
        int val = Integer.valueOf(new String(v1.reverse())) + Integer.valueOf(new String(v2.reverse()));
        ListNode head = new ListNode(val % 10);
        val /= 10;
        ListNode cur = head;
        ListNode node = null;
        int tmp = 0;
        while ((tmp = val % 10) != 0) {
            node = new ListNode(tmp);
            cur.next = node;
            cur = node;
            val = val / 10;
        }
        cur.next = null;
        return head;
    }
}