package necessary.class037;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *ClassName: _5_98
 *Package: necessary.class037
 *Description:创建于 2025/10/20 21:31
 *  https://leetcode.cn/problems/validate-binary-search-tree/
 *  一棵树的中序遍历一直递增 这棵树就是搜索二叉树
 *@Author lyl
 *@Version 1.0
 */
public class _5_98 {
}

//root.val必须在区间（left,right）之间

//class Solution {
//    public boolean isValidBST(TreeNode root) {
//        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//    private boolean dfs(TreeNode root, long left , long right) {
//        if (root == null) return true;
//        if (root.val <= left || root.val >= right) return false;
//        return dfs(root.left, left, root.val) && dfs(root.right, root.val, right);
//    }
//}


//
class Solution5 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}


//class Solution5 {
//    private long max, min;
//
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            max = Long.MIN_VALUE;
//            min = Long.MAX_VALUE;
//            return true;
//        }
//        boolean ret1 = isValidBST(root.left);
//        long lmax = max;
//        long lmin = min;
//        boolean ret2 = isValidBST(root.right);
//        long rmax = max;
//        long rmin = min;
//        max = Math.max(Math.max(lmax, rmax), root.val);
//        min = Math.min(Math.min(lmin, rmin), root.val);
//        return ret1 && ret2 && lmax < root.val && rmin > root.val;
//    }
//
//}

//利用中序遍历一直递增就是搜索二叉树的性质（迭代）
//class Solution {
//    private int MAXSIZE=10001;
//    private TreeNode[] stack=new TreeNode[MAXSIZE];
//    private int r;
//
//    public boolean isValidBST(TreeNode root) {
//        TreeNode pre=null;
//        r=0;
//        while(r>0||root!=null){
//            if(root!=null){
//                stack[r++]=root;
//                root=root.left;
//            }
//            else{
//                root = stack[--r];
//                if(pre!=null && pre.val>=root.val){
//                    return false;
//                }
//                pre=root;
//                root=root.right;
//            }
//        }
//        return true;
//    }
//}


//没考虑父节点的父节点也有大小要求
//class Solution {
//    public boolean isValidBST(TreeNode root) {
//        if (root == null || (root.left == null && root.right == null))
//            return true;
//        if (root.left != null && root.right != null) {
//            return root.val > root.left.val && root.val < root.right.val && isValidBST(root.left)
//                    && isValidBST(root.right);
//        } else if (root.left != null) {
//            return root.val > root.left.val && isValidBST(root.left);
//        } else {
//            return root.val < root.right.val && isValidBST(root.right);
//        }
//    }
//}