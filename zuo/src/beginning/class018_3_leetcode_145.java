package beginning;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *ClassName: class018_3_leetcode_145
 *Package: beginning
 *Description:创建于 2025/8/10 22:49
 *二叉树的后序遍历
 *时间复杂度：O(n)
 *空间复杂度：O(h)   h为二叉树的高度
 *@Author lyl
 *@Version 1.0
 */
public class class018_3_leetcode_145 {
}
//非递归
//一个栈
class Solution5 {
    public List<Integer> postorderTraversal(MyTreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        //栈用来返回上一层
        //root用来指示上一个遍历的节点
        Stack<MyTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            MyTreeNode cur = stack.peek();
            if (cur.left != null && root != cur.left && root != cur.right) {
                stack.push(cur.left);
            } else if (cur.right != null && root != cur.right) {
                stack.push(cur.right);
            } else {
                list.add(cur.val);
                root = stack.pop();
            }
        }
        return list;

    }
}


//两个栈（类似先序遍历）
//class Solution5 {
//    public List<Integer> postorderTraversal(MyTreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null)
//            return list;
//        Stack<MyTreeNode> stack = new Stack<>();
//        Stack<MyTreeNode> collect = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            MyTreeNode cur = stack.pop();
//            collect.push(cur);
//            if (cur.left != null) {
//                stack.push(cur.left);
//            }
//            if (cur.right != null) {
//                stack.push(cur.right);
//            }
//        }
//        while (!collect.isEmpty()) {
//            list.add(collect.pop().val);
//        }
//        return list;
//    }
//}
