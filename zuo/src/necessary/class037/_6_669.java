package necessary.class037;

/**
 *ClassName: _6_669
 *Package: necessary.class037
 *Description:创建于 2025/10/21 20:25
 * https://leetcode.cn/problems/trim-a-binary-search-tree/description/
 *@Author lyl
 *@Version 1.0
 */
public class _6_669 {
}

class Solution6 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        if (root.val >= low && root.val <= high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        } else if (root.val < low) {
            return trimBST(root.right, low, high);
        } else {
            return trimBST(root.left, low, high);
        }
    }
}