package necessary.class036;

/**
 *ClassName: _4_104
 *Package: necessary.class036
 *Description:创建于 2025/10/14 19:30
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 *@Author lyl
 *@Version 1.0
 */
public class _4_104 {
}
class Solution4 {
    public int maxDepth(TreeNode root) {
        return root==null?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}