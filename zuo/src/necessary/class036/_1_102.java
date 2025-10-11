package necessary.class036;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 *ClassName: _1_102
 *Package: necessary.class036
 *Description:创建于 2025/10/11 20:17
 *https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
 *树的层序遍历：使用队列
 *@Author lyl
 *@Version 1.0
 */
public class _1_102 {
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution1 {
    class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
    }

    private int MAXSIZE=2001;
    private TreeNode[] queue=new TreeNode[MAXSIZE];
    private int l,r;

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if(root!=null){
            l=r=0;
            queue[r++]=root;
            while(l<r){
                int size=r-l;
                List<Integer> list = new ArrayList<>();
                for (int i = 0 ; i < size ; i++) {
                    if(queue[l].left!=null)
                        queue[r++]=queue[l].left;
                    if(queue[l].right!=null)
                        queue[r++]=queue[l].right;
                    list.add(queue[l++].val);
                }
                lists.add(list);
            }
        }
        return lists;
    }
}