package necessary.class035;

import java.util.HashMap;

/**
 *ClassName: class035_2_leetcode_146
 *Package: necessary.class035
 *Description:创建于 2025/10/3 21:04
 * https://leetcode.cn/problems/lru-cache/
 *@Author lyl
 *@Version 1.0
 */
public class class035_2_leetcode_146 {
}

class LRUCache {

    class DoubleNode {
        int key;
        int value;
        DoubleNode last;
        DoubleNode next;
    }

    class DoubleList {
        DoubleNode head;
        DoubleNode tail;
        int num;
    }

    private int capacity;
    private DoubleList list;
    private HashMap<Integer, DoubleNode> map;

    public LRUCache (int capacity) {
        this.capacity = capacity;
        list = new DoubleList();
        list.head = list.tail = null;
        list.num = 0;
        map = new HashMap<>();
    }

    public int get (int key) {
        if (map.containsKey(key)) {
            int value = map.get(key).value;
            nodeToEnd(key);
            return value;
        }
        return - 1;
    }

    private void nodeToEnd (int key) {
        DoubleNode node = map.get(key);
        if (list.tail == node) {
            return;
        }
        if (list.head == node) {
            list.head = node.next;
            list.head.last = null;

        } else {
            DoubleNode pre = node.last;
            node.last = null;
            pre.next = node.next;
            node.next.last = pre;

        }
        node.next = null;
        node.last = list.tail;
        //遗漏了结点之间的连接
        list.tail.next = node;

        list.tail = node;
    }

    public void put (int key , int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            nodeToEnd(key);
        } else {
            if (list.num == capacity) {
                int k = removeHead();
                map.remove(k);
                list.num--;
            }
            DoubleNode node = addToEnd(key , value);
            map.put(key , node);
            list.num++;
        }
    }

    private DoubleNode addToEnd (int key , int value) {
        DoubleNode node = new DoubleNode();
        node.key = key;
        node.value = value;
        node.last = null;
        node.next = null;
        if (list.head == null && list.tail == null) {
            list.head = list.tail = node;
        } else {
            node.last = list.tail;
            list.tail.next = node;
            list.tail = node;
        }
        return node;
    }

    private int removeHead () {
        int key = list.head.key;
        //capacity=1的情况
        if (list.head == list.tail) {
            list.head = list.tail = null;

        } else {
            list.head = list.head.next;
            list.head.last = null;
        }
        return key;
    }
}
