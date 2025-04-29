/**
 * ClassName: leetcode_24
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/29 21:18
 *
 * @Author lyl
 * @Version 1.0
 */
public class leetcode_24 {
}

class Solution3 {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode counter=head;
        int num=1;
        while(counter.next !=null)
        {
            counter =counter .next ;
            num++;
        }
        ListNode pre=head;
        ListNode cur=pre.next ;
        ListNode newHead=cur;
        for (int i = 0 ; i < num/2 ; i++) {
            pre.next =cur.next ;
            cur.next =pre;
            pre=pre.next;
            if(pre!=null)
                cur=pre.next;
        }
        return newHead ;
    }
}