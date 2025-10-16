package necessary.class036;

/**
 *ClassName: _9_958
 *Package: necessary.class036
 *Description:创建于 2025/10/16 20:01
 *  https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
 *  是否是完全二叉树：
 *  1）有右无左--》一定不是
 *  2）第一个没有右孩子的结点后的 结点都得是叶子节点
 *@Author lyl
 *@Version 1.0
 */
public class _9_958 {
}

class Solution9 {
    private int MAXSIZE = 101;
    private TreeNode[] queue = new TreeNode[MAXSIZE];
    private int l, r;

    public boolean isCompleteTree (TreeNode root) {
        l = r = 0;
        queue[r++] = root;
        boolean leaf = false;
        while (l < r) {
            TreeNode node = queue[l++];
            if ((node.left == null && node.right != null) || leaf && (node.left != null || node.right != null))
                return false;
            if (node.left != null) {
                queue[r++] = node.left;
            }
            if (node.right != null) {
                queue[r++] = node.right;
            }
            if (node.right == null)
                leaf = true;
        }
        return true;
    }
}