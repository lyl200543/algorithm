package necessary.class038;

import java.util.Stack;

/**
 *ClassName: _5_stack_recursive_1
 *Package: necessary.class038
 *Description:创建于 2025/10/26 22:00
 *@Author lyl
 *@Version 1.0
 */
public class _5_stack_recursive_1 {

    public static void reverse(Stack<Integer> stack) {
        if (stack.size() == 1) {
            return;
        }
        Integer item = reverseHelper(stack);
        reverse(stack);
        stack.push(item);
    }

    //弹出栈的最后一个元素
    public static Integer reverseHelper(Stack<Integer> stack) {
        if (stack.size() == 1) {
            return stack.pop();
        }
        Integer item = stack.pop();
        Integer target = reverseHelper(stack);
        stack.push(item);
        return target;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }
}
