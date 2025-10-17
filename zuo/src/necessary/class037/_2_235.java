package necessary.class037;

/**
 *ClassName: _2_235
 *Package: necessary.class037
 *Description:创建于 2025/10/17 21:36
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *@Author lyl
 *@Version 1.0
 */
public class _2_235 {
}
class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        if ((p.val < root.val && q.val > root.val) || (q.val < root.val && p.val > root.val))
            return root;
        else if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else
            return lowestCommonAncestor(root.right, p, q);

        //迭代版：
//        while (root.val != p.val && root.val != q.val) {
//            if (Math.min(p.val, q.val) < root.val && root.val < Math.max(p.val, q.val)) {
//                break;
//            }
//            root = root.val < Math.min(p.val, q.val) ? root.right : root.left;
//        }
//        return root;
    }
}