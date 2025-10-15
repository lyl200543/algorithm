package necessary.class036;

import java.util.HashMap;

/**
 *ClassName: _8_105
 *Package: necessary.class036
 *Description:创建于 2025/10/15 20:37
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *@Author lyl
 *@Version 1.0
 */
public class _8_105 {
}

class Solution {
    public TreeNode buildTree (int[] preorder , int[] inorder) {
        if (preorder.length == 1)
            return new TreeNode(preorder[0]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < inorder.length ; i++) {
            map.put(inorder[i] , i);
        }
        return buildRecursive(preorder , 0 , preorder.length - 1 , inorder , 0 , inorder.length - 1 , map);
    }

    private TreeNode buildRecursive (int[] preorder , int l1 , int r1 , int[] inorder , int l2 , int r2 , HashMap<Integer, Integer> map) {
        if (l1 > r1)
            return null;
        TreeNode head = new TreeNode(preorder[l1]);
        if (l1 == r1)
            return head;
        int mid = map.get(preorder[l1]);
        head.left = buildRecursive(preorder , l1 + 1 , l1 + mid - l2 , inorder , l2 , mid - 1 , map);
        head.right = buildRecursive(preorder , l1 + mid - l2 + 1 , r1 , inorder , mid + 1 , r2 , map);
        return head;
    }
}
