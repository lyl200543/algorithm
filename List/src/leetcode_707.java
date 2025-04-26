/**
 * ClassName: leetcode_707
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/25 21:26
 *
 * @Author lyl
 * @Version 1.0
 */
public class leetcode_707 {
}

class Node {
    private int val;
    private Node next;

    public Node () {
    }

    public Node (int val , Node next) {
        this.val = val;
        this.next = next;
    }

    public int getVal () {
        return val;
    }

    public void setVal (int val) {
        this.val = val;
    }

    public Node getNext () {
        return next;
    }

    public void setNext (Node next) {
        this.next = next;
    }
}


class MyLinkedList {
    Node head;
    Node tail;
    int length;

    public MyLinkedList () {
        head = null;
        tail = null;
        length = 0;
    }

    public int get (int index) {
        if (index < 0 || index >= length) {
            return - 1;
        }
        Node node = findNodeAtIndex(index + 1);
        return node.getVal();
    }

    public void addAtHead (int val) {
        Node node = new Node(val , null);
        node.setNext(head);
        head = node;
        if (tail == null) {
            tail = node;
        }
        length++;
    }

    public void addAtTail (int val) {
        Node node = new Node(val , null);
        if (tail != null)
            tail.setNext(node);
        tail = node;
        if (head == null) {
            head = node;
        }
        length++;
    }

    public void addAtIndex (int index , int val) {
        if (index > length)
            return;
        if (index == length)
            addAtTail(val);
        else if (index == 0)
            addAtHead(val);
        else {
            Node node = new Node(val , null);
            Node beforeNode = findNodeAtIndex(index);
            node.setNext(beforeNode.getNext());
            beforeNode.setNext(node);
            length++;
        }
    }

    public void deleteAtIndex (int index) {
        if (index < 0 || index >= length) {
            return;
        }
        if (index == 0) {
            head = head.getNext();
        } else {
            Node beforenode = findNodeAtIndex(index);
            beforenode.setNext(beforenode.getNext().getNext());
            if (index == length - 1) {
                tail = beforenode;
            }
        }
        length--;
    }

    private Node findNodeAtIndex (int index) {
        Node node = head;
        for (int i = 0 ; i < index - 1 ; i++) {
            node = node.getNext();
        }
        return node;
    }
}



//class MyLinkedList {
//
//    class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int val) {
//            this.val=val;
//        }
//    }
//    //size存储链表元素的个数
//    private int size;
//    //注意这里记录的是虚拟头结点
//    private ListNode head;
//
//    //初始化链表
//    public MyLinkedList() {
//        this.size = 0;
//        this.head = new ListNode(0);
//    }
//
//    //获取第index个节点的数值，注意index是从0开始的，第0个节点就是虚拟头结点
//    public int get(int index) {
//        //如果index非法，返回-1
//        if (index < 0 || index >= size) {
//            return -1;
//        }
//        ListNode cur = head;
//        //第0个节点是虚拟头节点，所以查找第 index+1 个节点
//        for (int i = 0; i <= index; i++) {
//            cur = cur.next;
//        }
//        return cur.val;
//    }
//
//    public void addAtHead(int val) {
//        ListNode newNode = new ListNode(val);
//        newNode.next = head.next;
//        head.next = newNode;
//        size++;
//
//        // 在链表最前面插入一个节点，等价于在第0个元素前添加
//        // addAtIndex(0, val);
//    }
//
//
//    public void addAtTail(int val) {
//        ListNode newNode = new ListNode(val);
//        ListNode cur = head;
//        while (cur.next != null) {
//            cur = cur.next;
//        }
//        cur.next = newNode;
//        size++;
//
//        // 在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加
//        // addAtIndex(size, val);
//    }
//
//    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
//    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
//    // 如果 index 大于链表的长度，则返回空
//    public void addAtIndex(int index, int val) {
//        if (index < 0 || index > size) {
//            return;
//        }
//
//        //找到要插入节点的前驱
//        ListNode pre = head;
//        for (int i = 0; i < index; i++) {
//            pre = pre.next;
//        }
//        ListNode newNode = new ListNode(val);
//        newNode.next = pre.next;
//        pre.next = newNode;
//        size++;
//    }
//
//    public void deleteAtIndex(int index) {
//        if (index < 0 || index >= size) {
//            return;
//        }
//
//        //因为有虚拟头节点，所以不用对index=0的情况进行特殊处理
//        ListNode pre = head;
//        for (int i = 0; i < index ; i++) {
//            pre = pre.next;
//        }
//        pre.next = pre.next.next;
//        size--;
//    }
//}