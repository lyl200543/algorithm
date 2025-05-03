import java.lang.module.FindException;

/**
 * ClassName: leetcode_19
 * Package: PACKAGE_NAME
 * Description:创建于 2025/5/3 20:10
 *
 * @Author lyl
 * @Version 1.0
 */
public class leetcode_19 {
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution4 {
    public ListNode removeNthFromEnd (ListNode head , int n) {
//        if (n <= 0)
//            return head;
//        ListNode counter = head;
//        int count = 0;
//        while (counter != null) {
//            counter = counter.next;
//            count++;
//        }
//        int num = count - n;
//        if (num < 0)
//            return head;
//        else if (num == 0) {
//            return head.next;
//        } else {
//            ListNode tmp = head;
//            while (num - 1 > 0) {
//                tmp = tmp.next;
//                num--;
//            }
//            ListNode tmp2 = tmp.next;
//            tmp.next = tmp2.next;
//            tmp2.next = null;
//            return head;
//        }

//        if(n<=0)
//            return head;
//        ListNode vNode=new ListNode(-1);
//        vNode.next=head;
//        ListNode cur = vNode;
//        ListNode front = head;
//        int num = n;
//        while (front != null && num > 0) {
//            front = front.next;
//            num--;
//        }
//        if(num==0){
//            while(front!=null){
//                front=front.next;
//                cur=cur.next;
//            }
//            cur.next=cur.next.next;
//        }
//        else{
//            return head;
//        }
//        return vNode.next;

        //递归版本
        ListNode vNode = new ListNode(- 1 , head);
        remove(vNode , n);
        return vNode.next;
    }

    public int remove (ListNode node , int n) {
        if (node == null)
            return 0;
        int num = remove(node.next , n);
        if (num == n)
            node.next = node.next.next;
        return num + 1;
    }
}

