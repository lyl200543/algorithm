import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 *ClassName: leetcode_150
 *Package: PACKAGE_NAME
 *Description:创建于 2025/7/19 21:45
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_150 {
    public static void main (String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    @Test
    public void test(){
        System.out.println("-11".matches("-?\\d+"));
    }
}

//class Solution2 {
//    public int evalRPN (String[] tokens) {
//        Deque<Integer> stack = new ArrayDeque<>();
//        for (int i = 0 ; i < tokens.length ; i++) {
//            if (tokens[i].matches("-?\\d+")) {
//                int x = Integer.parseInt(tokens[i]);
//                stack.push(x);
//            } else {
//                if (tokens[i].equals("+")) {
//                    int a = stack.pop();
//                    int b = stack.pop();
//                    stack.push(b + a);
//                } else if (tokens[i].equals("-")) {
//                    int a = stack.pop();
//                    int b = stack.pop();
//                    stack.push(b - a);
//                } else if (tokens[i].equals("*")) {
//                    int a = stack.pop();
//                    int b = stack.pop();
//                    stack.push(b * a);
//                } else if (tokens[i].equals("/")) {
//                    int a = stack.pop();
//                    int b = stack.pop();
//                    stack.push(b / a);
//                }
//            }
//        }
//        return stack.peek();
//    }
//}


//改进：
class Solution2 {
    int index = 0;
    public int evalRPN(String[] tokens) {
        index = tokens.length - 1;
        return cal(tokens);
    }
    public int cal(String[] tokens) {
        if (tokens[index].equals("*")) {
            index--;
            return cal(tokens) * cal(tokens);
        } else if (tokens[index].equals("/")) {
            index--;
            int a = cal(tokens);
            int b = cal(tokens);
            return b / a;
        } else if (tokens[index].equals("+")) {
            index--;
            return cal(tokens) + cal(tokens);
        } else if (tokens[index].equals("-")) {
            index--;
            int a = cal(tokens);
            int b = cal(tokens);
            return b - a;
        } else {
            return Integer.valueOf(tokens[index--]);
        }
    }
}