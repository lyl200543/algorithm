/**
 * ClassName: leetcode_02_07
 * Package: PACKAGE_NAME
 * Description:创建于 2025/5/3 20:51
 *
 * @Author lyl
 * @Version 1.0
 */
public class leetcode_02_07 {
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution5 {
    public ListNode getIntersectionNode (ListNode headA , ListNode headB) {
//        ListNode nodeA = headA;
//        ListNode nodeB = headB;
//
//        while (nodeA != null) {
//            nodeB = headB;
//            while (nodeB != null) {
//                if (nodeA == nodeB) {
//                    return nodeA;
//                }
//                nodeB = nodeB.next;
//            }
//            nodeA = nodeA.next;
//        }
//        return null;


        //改进：
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int a = 0;
        int b = 0;
        while (nodeA != null) {
            nodeA = nodeA.next;
            a++;
        }
        while (nodeB != null) {
            nodeB = nodeB.next;
            b++;
        }
        int num = a - b;
        nodeA = headA;
        nodeB = headB;
        if (num >= 0) {
            for (int i = 0 ; i < num ; i++) {
                nodeA = nodeA.next;
            }

        } else {
            num = - num;
            for (int i = 0 ; i < num ; i++) {
                nodeB = nodeB.next;
            }
        }
        while (nodeA != nodeB && nodeA != null) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;

        }
        if(nodeA==nodeB)
            return nodeA;
        return null;

    }
}