package necessary.class036;

/**
 *ClassName: _3_662
 *Package: necessary.class036
 *Description:创建于 2025/10/12 20:23
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/description/
 *@Author lyl
 *@Version 1.0
 */
public class _3_662 {
}
class Solution3 {
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

    private int MAXSIZE = 3001;
    private TreeNode[] queue = new TreeNode[MAXSIZE];
    private int[] index = new int[MAXSIZE];
    private int l, r;

    //利用完全二叉树的父节点和子节点的关系，以及结点之间的数量关系
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 1;
        l = r = 0;
        queue[r] = root;
        index[r++] = 1;
        while (l < r) {
            int size = r - l;
            ans = Math.max(ans, index[r - 1] - index[l] + 1);
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue[l];
                int d = index[l++];
                if (cur.left != null) {
                    queue[r] = cur.left;
                    index[r++] = d * 2;
                }
                if (cur.right != null) {
                    queue[r] = cur.right;
                    index[r++] = d * 2 + 1;
                }
            }

        }
        return ans;
    }
}