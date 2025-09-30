package necessary.class034;



/**
 *ClassName: class034_1_leetcode_160
 *Package: necessary.class034
 *Description:创建于 2025/9/30 19:42
 *https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 *@Author lyl
 *@Version 1.0
 */
public class class034_1_leetcode_160 {
}

class Solution20 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null | headB==null)
            return null;
        ListNode a=headA;
        ListNode b=headB;
        int countA=1;
        int countB=1;
        while(a.next!=null){
            a=a.next;
            countA++;
        }
        while(b.next!=null){
            b=b.next;
            countB++;
        }
        if(a!=b)
            return null;
        a=headA;
        b=headB;
        if(countA<countB){
            int diff=countB-countA;
            while(diff>0){
                b=b.next;
                diff--;
            }
            while(a!=b){
                a=a.next;
                b=b.next;
            }
        }else {
            int diff=countA-countB;
            while(diff>0){
                a=a.next;
                diff--;
            }
            while(a!=b){
                a=a.next;
                b=b.next;
            }
        }
        return a;
    }
}