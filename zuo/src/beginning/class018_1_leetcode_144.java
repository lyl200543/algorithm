package beginning;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *ClassName: class018_1_leetcode_144
 *Package: beginning
 *Description:创建于 2025/8/10 22:08
 *二叉树的先序遍历
 *@Author lyl
 *@Version 1.0
 */

class MyTreeNode {
    int val;
    MyTreeNode left;
    MyTreeNode right;
    MyTreeNode () {}
    MyTreeNode (int val) { this.val = val; }
    MyTreeNode (int val, MyTreeNode left, MyTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//非递归：
class Solution3 {
    public List<Integer> preorderTraversal(MyTreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        Stack<MyTreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            MyTreeNode cur=stack.pop();
            list.add(cur.val);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
        }
        return list;
    }
}
//递归：
//class Solution3 {
//    public List<Integer> preorderTraversal(MyTreeNode root) {
//        List<Integer> list = new ArrayList<Integer>();
//        preOrder(root, list);
//        return list;
//    }
//
//    public void preOrder(MyTreeNode root, List<Integer> list) {
//        if (root == null)
//            return;
//        list.add(root.val);
//        preOrder(root.left, list);
//        preOrder(root.right, list);
//    }
//}

public class class018_1_leetcode_144 {
}
