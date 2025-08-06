package beginning;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *ClassName: class015_leetcode_147
 *Package: beginning
 *Description:创建于 2025/8/6 21:49
 * 最小栈：在常数时间内找到栈内最小值
 *@Author lyl
 *@Version 1.0
 */
public class class015_leetcode_147 {
}

class MinStack {
    Deque<Integer> data;
    Deque<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        data = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }

    public void push(int x) {
        data.push(x);
        if(min.isEmpty() || x < min.peek()){
            min.push(x);
        }else{
            min.push(min.peek());
        }

    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}