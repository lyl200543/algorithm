package necessary.class036;

/**
 *ClassName: _10_222
 *Package: necessary.class036
 *Description:创建于 2025/10/16 20:54
 * https://leetcode.cn/problems/count-complete-tree-nodes/
 * 时间复杂度小于O(n)
 *@Author lyl
 *@Version 1.0
 */
public class _10_222 {
}

class Solution10 {
    public int countNodes (TreeNode root) {
        if (root == null)
            return 0;
        return count(root , 1 , countLevel(root));
    }

    private int count (TreeNode root , int level , int h) {
        if (level == h)
            return 1;
        int rLevel = countLevel(root.right);
        if (rLevel == h - level) {
            return (1 << rLevel) + count(root.right , level + 1 , h);
        } else {
            return (1 << rLevel) + count(root.left , level + 1 , h);
        }
    }

    private int countLevel (TreeNode head) {
        int level = 0;
        while (head != null) {
            level++;
            head = head.left;
        }
        return level;
    }
}
