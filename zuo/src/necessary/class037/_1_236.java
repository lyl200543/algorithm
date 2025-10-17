package necessary.class037;

/**
 *ClassName: _1_236
 *Package: necessary.class037
 *Description:创建于 2025/10/17 20:25
 *  https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 *@Author lyl
 *@Version 1.0
 */
public class _1_236 {
}

class Solution1 {
    public TreeNode lowestCommonAncestor (TreeNode root , TreeNode p , TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode l = lowestCommonAncestor(root.left , p , q);
        TreeNode r = lowestCommonAncestor(root.right , p , q);
        if (l != null && r != null)
            return root;
        if (l == null && r == null)
            return null;
        return l == null ? r : l;
    }
}