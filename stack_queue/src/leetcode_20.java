import java.util.Stack;

/**
 *ClassName: leetcode_20
 *Package: PACKAGE_NAME
 *Description:创建于 2025/7/18 21:13
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_20 {
    public static void main (String[] args) {
        Solution solution = new Solution();
        solution.isValid("()[]{}");
    }
}


//class Solution {
//    public boolean isValid (String s) {
//        char[] arr = s.toCharArray();
//        int count = arr.length;
//        Stack<Character> stack = new Stack<>();
//        stack.push(arr[0]);
//        for (int i = 1 ; i < count ; i++) {
//            if (!stack.isEmpty() && (stack.peek() + 1 == (int) arr[i] || stack.peek() + 2 == (int) arr[i])) {
//                stack.pop();
//            } else
//                stack.push(arr[i]);
//        }
//        return stack.isEmpty();
//    }
//}


//改进：
class Solution {
    public boolean isValid (String s) {
        char[] arr = s.toCharArray();
        int top = - 1;
        char[] stack = new char[s.length()];
        for (int i = 0 ; i < s.length() ; i++) {
            if (arr[i] == '(') {
                stack[++ top] = ')';
            } else if (arr[i] == '{') {
                stack[++ top] = '}';
            } else if (arr[i] == '[') {
                stack[++ top] = ']';
            } else if (top == - 1 || arr[i] != stack[top--]) {
                return false;
            }
        }
        return top == - 1;
    }
}