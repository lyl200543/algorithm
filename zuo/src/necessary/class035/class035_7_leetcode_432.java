package necessary.class035;

import java.util.HashMap;
import java.util.HashSet;

/**
 *ClassName: class035_7_leetcode_432
 *Package: necessary.class035
 *Description:创建于 2025/10/9 19:05
 * https://leetcode.cn/problems/all-oone-data-structure/
 * 使用哈希表和双向链表（元素为桶）
 *@Author lyl
 *@Version 1.0
 */
public class class035_7_leetcode_432 {
}
class AllOne {
    class Bucket {
        HashSet<String> set;
        int cnt;
        Bucket last;
        Bucket next;

        Bucket(String s, int c) {
            set = new HashSet<>();
            set.add(s);
            cnt = c;
        }

    }

    private void Insert(Bucket b1, Bucket b2) {
        b2.next = b1.next;
        b1.next = b2;
        b2.next.last = b2;
        b2.last = b1;
    }

    private void Remove(Bucket b) {
        b.last.next = b.next;
        b.next.last = b.last;
    }

    private Bucket head;
    private Bucket tail;
    private HashMap<String, Bucket> map;

    public AllOne() {
        head = new Bucket("", 0);
        tail = new Bucket("", Integer.MAX_VALUE);
        head.next = tail;
        tail.last = head;
        map = new HashMap<>();
    }

    public void inc(String key) {
        if (!map.containsKey(key)) {
            if (head.next.cnt != 1) {
                Bucket b = new Bucket(key, 1);
                Insert(head, b);
                map.put(key, b);
            } else {
                head.next.set.add(key);
                map.put(key, head.next);
            }
        } else {
            Bucket cur = map.get(key);
            if (cur.next.cnt != cur.cnt + 1) {
                Bucket b = new Bucket(key, cur.cnt + 1);
                Insert(cur, b);
                map.put(key, b);
            } else {
                cur.next.set.add(key);
                map.put(key, cur.next);
            }
            cur.set.remove(key);
            if (cur.set.isEmpty())
                Remove(cur);
        }
    }

    public void dec(String key) {
        Bucket cur = map.get(key);
        if (cur.cnt - 1 == 0) {
            map.remove(key);
        } else {
            if (cur.last.cnt != cur.cnt - 1) {
                Bucket b = new Bucket(key, cur.cnt - 1);
                Insert(cur.last, b);
                map.put(key, b);
            } else {
                cur.last.set.add(key);
                map.put(key, cur.last);
            }
        }
        cur.set.remove(key);
        if (cur.set.isEmpty())
            Remove(cur);
    }

    public String getMaxKey() {
        if (tail.last.cnt != 0) {
            return tail.last.set.iterator().next();
        }
        return "";
    }

    public String getMinKey() {
        if (head.next.cnt != Integer.MAX_VALUE) {
            return head.next.set.iterator().next();
        }
        return "";
    }
}