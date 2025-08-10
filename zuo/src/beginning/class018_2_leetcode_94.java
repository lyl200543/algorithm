package beginning;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *ClassName: class018_2_leetcode_94
 *Package: beginning
 *Description:创建于 2025/8/10 22:26
 *二叉树的中序遍历
 *@Author lyl
 *@Version 1.0
 */
public class class018_2_leetcode_94 {
}

//非递归
class Solution4 {
    public List<Integer> inorderTraversal(MyTreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<MyTreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}