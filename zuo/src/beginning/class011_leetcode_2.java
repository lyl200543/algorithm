package beginning;

/**
 *ClassName: class011_leetcode_2
 *Package: beginning
 *Description:创建于 2025/8/3 21:50
 *@Author lyl
 *@Version 1.0
 */
public class class011_leetcode_2 {
    public static void main (String[] args) {
        Solution1 solution1 = new Solution1();
        ListNode l1 = new ListNode(2 , new ListNode(4 , new ListNode(3 , null)));
        ListNode l2 = new ListNode(5 , new ListNode(6 , new ListNode(4 , null)));
        ListNode listNode = solution1.addTwoNumbers(l1 , l2);
        System.out.println(listNode);
    }
}

class Solution1 {
    public ListNode addTwoNumbers (ListNode l1 , ListNode l2) {
        int carry = 0;
        ListNode ans = null, cur = null;
        for (; l1 != null || l2 != null; l1 = l1 == null ? null : l1.next, l2 = l2 == null ? null : l2.next) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            int val = sum % 10;
            carry = sum / 10;
            if (ans == null) {
                ans = new ListNode(val);
                cur = ans;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        if(carry==1){
            cur.next=new ListNode(1);
        }
        return ans;

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


        //int类型最大值过小
//        StringBuilder v1 = new StringBuilder("");
//        StringBuilder v2 = new StringBuilder("");
//        while (l1 != null) {
//            v1 = v1.append(l1.val);
//            l1 = l1.next;
//        }
//        while (l2 != null) {
//            v2 = v2.append(l2.val);
//            l2 = l2.next;
//        }
//        int val = Integer.valueOf(new String(v1.reverse())) + Integer.valueOf(new String(v2.reverse()));
//        ListNode head = new ListNode(val % 10);
//        val /= 10;
//        ListNode cur = head;
//        ListNode node = null;
//        int tmp = 0;
//        while (val / 10 != 0 || val % 10 != 0) {
//            tmp = val % 10;
//            node = new ListNode(tmp);
//            cur.next = node;
//            cur = node;
//            val = val / 10;
//        }
//        cur.next = null;
//        return head;
//    }


        //long类型最大值过小
//        StringBuilder v1 = new StringBuilder("");
//        StringBuilder v2 = new StringBuilder("");
//        while (l1 != null) {
//            v1 = v1.append(l1.val);
//            l1 = l1.next;
//        }
//        while (l2 != null) {
//            v2 = v2.append(l2.val);
//            l2 = l2.next;
//        }
//        long val = Long.valueOf(new String(v1.reverse())) + Long.valueOf(new String(v2.reverse()));
//        char[] arr = Long.toString(val).toCharArray();
//        ListNode cur = new ListNode(arr[arr.length - 1] - '0');
//        ListNode head = cur;
//        for (int i = arr.length - 2 ; i >= 0 ; i--) {
//            ListNode node = new ListNode(arr[i] - '0');
//            cur.next = node;
//            cur = node;
//        }
//        return head;


        //未考虑相加有进位情况
//        StringBuilder v1 = new StringBuilder("");
//        StringBuilder v2 = new StringBuilder("");
//        while (l1 != null) {
//            v1 = v1.append(l1.val);
//            l1 = l1.next;
//        }
//        while (l2 != null) {
//            v2 = v2.append(l2.val);
//            l2 = l2.next;
//        }
//        char[] arr1 = v1.toString().toCharArray();
//        char[] arr2 = v1.toString().toCharArray();
//        int val1 = arr1[arr1.length - 1] - '0';
//        int val2 = arr1[arr2.length - 1] - '0';
//        ListNode cur = new ListNode(val1 + val2);
//        ListNode head = cur;
//        int i, j;
//        for (i = arr1.length - 2 , j = arr2.length - 2; i >= 0 && j >= 0 ; i-- , j--) {
//            val1 = arr1[i] - '0';
//            val2 = arr2[j] - '0';
//            ListNode node = new ListNode(val1 + val2);
//            cur.next = node;
//            cur = node;
//        }
//        while (i >= 0) {
//            ListNode node = new ListNode(arr1[i] - '0');
//            cur.next = node;
//            cur = node;
//            i--;
//        }
//        while (j >= 0) {
//            ListNode node = new ListNode(arr2[j] - '0');
//            cur.next = node;
//            cur = node;
//            j--;
//        }
//        return head;
    }
}