package necessary.class036;

/**
 *ClassName: _5_111
 *Package: necessary.class036
 *Description:创建于 2025/10/14 19:34
 *https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/
 *@Author lyl
 *@Version 1.0
 */
public class _5_111 {
}
class Solution5 {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        int lmin=Integer.MAX_VALUE;
        int rmin=Integer.MAX_VALUE;
        if(root.left!=null){
            lmin=minDepth(root.left);
        }
        if(root.right!=null){
            rmin=minDepth(root.right);
        }
        return Math.min(lmin,rmin);
    }
}