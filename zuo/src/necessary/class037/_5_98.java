package necessary.class037;

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
class Solution5 {
    public boolean isValidBST(TreeNode root) {

    }
}

//利用中序遍历一直递增就是搜索二叉树的性质（迭代）
class Solution {
    public boolean isValidBST(TreeNode root) {
        
    }
}


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