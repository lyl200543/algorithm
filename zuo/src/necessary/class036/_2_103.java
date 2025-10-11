package necessary.class036;

import java.util.ArrayList;
import java.util.List;

/**
 *ClassName: _2_103
 *Package: necessary.class036
 *Description:创建于 2025/10/11 20:47
 *  https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 *@Author lyl
 *@Version 1.0
 */
public class _2_103 {
}

class Solution2 {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if(root!=null){
            l=r=0;
            queue[r++]=root;
            while(l<r){
                
            }
        }
        return lists;
    }
}