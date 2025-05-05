import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: leetcode_142
 * Package: PACKAGE_NAME
 * Description:创建于 2025/5/4 21:47
 *
 * @Author lyl
 * @Version 1.0
 */
public class leetcode_142 {
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution6 {
    public ListNode detectCycle (ListNode head) {
//        if (head == null || head.next == null)
//            return head;
//        List<ListNode> list=new ArrayList<>();
//        ListNode cur=head;
//        while(cur!=null){
//            if (!list.contains(cur)) {
//                list.add(cur);
//            }
//            else{
//                return cur;
//            }
//            cur=cur.next;
//        }
//        return null;


        //超级改进：
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode p1 = head;
                ListNode p2 = fast;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }
}