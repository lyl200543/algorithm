package beginning;

/**
 *ClassName: class012_leetcode_89
 *Package: beginning
 *Description:创建于 2025/8/4 21:49
 *@Author lyl
 *@Version 1.0
 */
public class class012_leetcode_86 {
    public static void main (String[] args) {
        Solution2 solution2 = new Solution2();
//        ListNode node = new ListNode(1,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(5,new ListNode(2,null))))));
        ListNode node = new ListNode(1 , new ListNode(1 , null));
        solution2.partition(node,2);
    }

}

class Solution2 {
    public ListNode partition(ListNode head, int x) {
        //比x小/大的区域分别设有一头一尾
        ListNode minHead=null,minTail=null,maxHead=null,maxTail=null;
        ListNode next=null;
        while(head!=null){
            next=head.next;
            head.next=null;
            if(head.val<x){
                if(minHead==null){
                    minHead=head;
                }else{
                    minTail.next=head;
                }
                minTail=head;
            }else{
                if(maxHead==null){
                    maxHead=head;
                }
                else{
                    maxTail.next=head;
                }
                maxTail=head;
            }
            head=next;
        }
        if(minHead==null){
            return maxHead;
        }
        minTail.next =maxHead ;
        return minHead;


        //正确（空指针的情况考虑不全面）
//        if (head == null) {
//            return null;
//        }
//        ListNode ans = null;
//        ListNode pre = null;
//        ListNode node = head;
//        ListNode min = null;
//        ListNode maxNode = null;
        // while (node != null) {
        //     if (ans == null && node.val < x) {
        //         ans = node;
        //         min=ans;
        //         if (pre != null) {
        //             pre.next = node.next;
        //         }
        //         node = node.next;
        //     }
        //     if (ans != null && node.val < x) {
        //         min.next = node;
        //         min = min.next;
        //         pre.next = node.next;
        //         node = node.next;
        //     }
        //     if (node.val >= x) {
        //         if (maxNode == null) {
        //             maxNode = node;
        //         }
        //         pre = node;
        //         node = node.next;
        //     }

//        while (node != null) {
//            if (node.val < x) {
//                if (ans == null) {
//                    ans = node;
//                    min = ans;
//                    if (pre != null) {
//                        pre.next = node.next;
//                    }
//                } else {
//                    min.next = node;
//                    min = min.next;
//                    if (pre != null) {
//                        pre.next = node.next;
//                    }
//                }
//            } else {
//                if (maxNode == null) {
//                    maxNode = node;
//                }
//                pre = node;
//            }
//            node=node.next;
//        }
//        if (min != null) {
//            min.next = maxNode;
//            return ans;
//        }
//        return head;
    }
}