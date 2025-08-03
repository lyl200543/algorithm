package beginning;

/**
 *ClassName: class010_leetcode_21
 *Package: beginning
 *Description:创建于 2025/8/3 20:37
 *@Author lyl
 *@Version 1.0
 */
public class class010_leetcode_21 {
    //合并两个有序链表
    //自己的版本（错误）
    //忽略特殊条件，漏掉元素，没考虑一条链表上连续元素小于另一条链表的情况
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if (list1 == null)
//            return list2;
//        if (list2 == null)
//            return list1;
//        ListNode node1 = list1;
//        ListNode node2 = list2;
//        while (node1 != null && node2 != null) {
//            // if (node1.val > node2.val) {
//            //     ListNode tmp = node2.next;
//            //     node2.next = node1;
//            //     node2 = tmp;
//            // } else {
//            //     ListNode tmp = node1.next;
//            //     node1.next = node2;
//            //     node1 = tmp;
//            // }
//            if (node1.val > node2.val) {
//                while (node2.next != null && node1.val > node2.next.val) {
//                    node2 = node2.next;
//                }
//            }
//        }
//        return list1.val > list2.val ? list2 : list1;
//    }

    //pre指向确定的合并链表的最大值
    //再从两个链表的最小值中选出更小值作为pre
    public ListNode mergeTwoLists (ListNode list1 , ListNode list2) {
        if (list1 == null || list2 == null)
            return list1 == null ? list2 : list1;
        ListNode head = list1.val <= list2.val ? list1 : list2;
        ListNode pre = head;
        ListNode cur1 = head.next;
        ListNode cur2 = head == list1 ? list2 : list1;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

}

