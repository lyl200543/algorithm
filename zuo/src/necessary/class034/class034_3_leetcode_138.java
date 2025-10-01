package necessary.class034;

/**
 *ClassName: class034_3_leetcode_138
 *Package: necessary.class034
 *Description:创建于 2025/10/1 19:08
 *https://leetcode.cn/problems/copy-list-with-random-pointer/
 *@Author lyl
 *@Version 1.0
 */
public class class034_3_leetcode_138 {
}
class Solution22 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node p = head;
        Node copy = null;
        //建立新老结点的关系
        while (p != null) {
            copy = new Node(p.val);
            Node next = p.next;
            p.next = copy;
            copy.next = next;
            p = next;
        }
        //设置random结点
        p = head;
        while (p != null) {
            copy = p.next;
            copy.random = p.random == null ? null : p.random.next;
            p = copy.next;
        }
        //断开链表
        p = head;
        copy = p.next;
        Node result = copy;
        while (copy.next != null) {
            Node next = copy.next;
            p.next = next;
            copy.next = next.next;
            p = next;
            copy = p.next;
        }
        p.next = null;
        return result;
    }
}