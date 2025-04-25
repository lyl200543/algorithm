/**
 * ClassName: leetcode_203
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/23 20:57
 *
 * @Author lyl
 * @Version 1.0
 */
public class leetcode_203 {

}

class ListNode {
    int val;
    ListNode next;

    ListNode () {
    }

    ListNode (int val) {
        this.val = val;
    }

    ListNode (int val , ListNode next) {
        this.val = val;
        this.next = next;
    }
}

//虚拟头结点：
class Solution {
    public ListNode removeElements (ListNode head , int val) {
//        ListNode node = new ListNode();
//        node.next = head;
//        ListNode newhead = node;
//        if (head != null) {
//            while (node.next != null) {
//                if (node.next.val == val)
//                    node.next = node.next.next;
//                else
//                    node = node.next;
//            }
//        }
//        return newhead.next;


        //递归：
        if (head == null)
            return head;
        head.next = removeElements(head.next , val);
        if (head.val == val) {
            return head.next;
        }
        return head;
    }
}


//递归版本：

//class Solution {
//    public ListNode removeElements(ListNode head, int val) {
//        if (head == null) {
//            return head;
//        }
//
//        // 假设 removeElements() 返回后面完整的已经去掉val节点的子链表
//        // 在当前递归层用当前节点接住后面的子链表
//        // 随后判断当前层的node是否需要被删除，如果是，就返回
//        // 也可以先判断是否需要删除当前node，但是这样条件语句会比较不好想
//        head.next = removeElements(head.next, val);
//        if (head.val == val) {
//            return head.next;
//        }
//        return head;
//
//        // 实际上就是还原一个从尾部开始重新构建链表的过程
//    }
//}