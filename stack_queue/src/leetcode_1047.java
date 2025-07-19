/**
 *ClassName: leetcode_1047
 *Package: PACKAGE_NAME
 *Description:创建于 2025/7/18 22:29
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_1047 {
    public static void main (String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.removeDuplicates("abbaca"));
    }
}

class Solution1 {
    public String removeDuplicates (String s) {
        char[] arr = s.toCharArray();
        char[] stack = new char[s.length()];
        int top = - 1;
        for (int i = 0 ; i < s.length() ; i++) {
            if (top != - 1 && arr[i] == stack[top]) {
                top--;
            } else {
                stack[++ top] = arr[i];
            }
        }
        String str = new String(stack);
        return str.substring(0 , top + 1);
    }
}