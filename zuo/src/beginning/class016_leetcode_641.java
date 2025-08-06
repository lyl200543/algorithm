package beginning;

import java.util.Deque;
import java.util.LinkedList;

/**
 *ClassName: class016_leetcode_641
 *Package: beginning
 *Description:创建于 2025/8/6 22:27
 *@Author lyl
 *@Version 1.0
 */
public class class016_leetcode_641 {
}

class MyCircularDeque {
    int[] deque;
    int size, limit, l, r;

    public MyCircularDeque(int k) {
        deque = new int[k];
        limit = k;
        size = 0;
        l = r = 0;
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;
        else {
            if (size == 0) {
                deque[0] = value;
                l = r = 0;
            } else {
                l = l == 0 ? limit - 1 : (l - 1);
                deque[l] = value;
            }
            size++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;
        else {
            if (size == 0) {
                deque[0] = value;
                l = r = 0;
            } else {
                r = (r == limit - 1) ? 0 : (r + 1);
                deque[r] = value;
            }
            size++;
            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;
        else {
            l = (l == limit - 1) ? 0 : (l + 1);
            size--;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;
        else {
            r = r == 0 ? limit - 1 : (r - 1);
            size--;
            return true;
        }
    }

    public int getFront() {
        if (size == 0)
            return -1;
        return deque[l];
    }

    public int getRear() {
        if (size == 0)
            return -1;
        return deque[r];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

class MyCircularDeque1 {
    Deque<Integer> deque;
    int size;

    public MyCircularDeque1(int k) {
        deque = new LinkedList<>();
        size = k;

    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;
        else {
            deque.offerFirst(value);
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;
        else {
            deque.offerLast(value);
            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;
        else {
            deque.pollFirst();
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;
        else {
            deque.pollLast();
            return true;
        }
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return deque.peekFirst();
    }

    public int getRear() {
        if (isEmpty())
            return -1;
        return deque.peekLast();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public boolean isFull() {
        return deque.size() == size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */