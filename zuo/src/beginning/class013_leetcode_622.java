package beginning;

/**
 *ClassName: class013_leetcode_622
 *Package: beginning
 *Description:创建于 2025/8/5 21:21
 *设计循环队列
 *@Author lyl
 *@Version 1.0
 */
public class class013_leetcode_622 {
}

class MyCircularQueue {
    int[] queue;
    int l = 0, r = 0;
    int size = 0;
    int count = 0;

    public MyCircularQueue(int k) {
        queue = new int[k];
        size = k;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        count++;
        queue[r] = value;
        r = r == size - 1 ? 0 : r + 1;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        count--;
        l = l == size - 1 ? 0 : l + 1;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return queue[l];

    }

    public int Rear() {
        if (isEmpty())
            return -1;
        int res = r == 0 ? size - 1 : r - 1;
        return queue[res];
    }

    public boolean isEmpty() {
        if (count == 0)
            return true;
        return false;
    }

    public boolean isFull() {
        if (count == size)
            return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */