import java.util.ArrayDeque;
import java.util.Queue;

/**
 *ClassName: leetcode_225
 *Package: PACKAGE_NAME
 *Description:创建于 2025/7/11 20:17
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_225 {
}

//class MyStack {
//    private ArrayDeque<Integer> deque1;
//    private ArrayDeque<Integer> deque2;
//
//    public MyStack () {
//        deque1 = new ArrayDeque<Integer>();
//        deque2 = new ArrayDeque<Integer>();
//
//    }
//
//    public void push (int x) {
//        if (deque1.isEmpty()) {
//            deque2.add(x);
//        } else {
//            deque1.add(x);
//        }
//    }
//
//    public int pop () {
//        if (deque1.isEmpty()) {
//            while (deque2.size() > 1) {
//                deque1.add(deque2.pop());
//            }
//            return deque2.pop();
//        } else {
//            while (deque1.size() > 1) {
//                deque2.add(deque1.pop());
//            }
//            return deque1.pop();
//        }
//    }
//
//    public int top () {
//        if (deque1.isEmpty()) {
//            while (deque2.size() > 1) {
//                deque1.add(deque2.pop());
//            }
//            int tmp = deque2.pop();
//            deque1.add(tmp);
//            return tmp;
//        } else {
//            while (deque1.size() > 1) {
//                deque2.add(deque1.pop());
//            }
//            int tmp = deque1.pop();
//            deque2.add(tmp);
//            return tmp;
//        }
//    }
//
//    public boolean empty () {
//        return deque1.isEmpty() && deque2.isEmpty();
//    }
//}


//改进
class MyStack {
    private Queue<Integer> queue;

    public MyStack () {
        queue = new ArrayDeque<>();
    }

    public void push (int x) {
        queue.add(x);
        int count = queue.size() - 1;
        while (count > 0) {
            queue.add(queue.poll());
            count--;
        }

    }

    public int pop () {
        return queue.poll();
    }

    public int top () {
        return queue.peek();
    }

    public boolean empty () {
        return queue.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */