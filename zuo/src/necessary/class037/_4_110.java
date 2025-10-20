package necessary.class037;

/**
 *ClassName: _4_110
 *Package: necessary.class037
 *Description:创建于 2025/10/20 21:25
 * https://leetcode.cn/problems/balanced-binary-tree/submissions/672191395/
 *@Author lyl
 *@Version 1.0
 */
public class _4_110 {
}
class Solution4 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}

//提前结束检查
//class Solution {
//    private boolean balanced;
//
//    public boolean isBalanced(TreeNode root) {
//        balanced = true;
//        height(root);
//        return balanced;
//    }
//
//    private int height(TreeNode root) {
//        if (root == null)
//            return 0;
//        int l = height(root.left);
//        int r = height(root.right);
//        if (Math.abs(l - r) > 1) {
//            balanced = false;
//            return 0;
//        }
//        return 1 + Math.max(l, r);
//
//    }
//}