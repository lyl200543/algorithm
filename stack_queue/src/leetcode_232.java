import java.util.Stack;

/**
 *ClassName: leetcode_232
 *Package: PACKAGE_NAME
 *Description:创建于 2025/7/11 19:48
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_232 {
}
class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1=new Stack();
        stack2=new Stack();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while(stack2.isEmpty()){
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int peek() {
        while(stack2.isEmpty()){
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */