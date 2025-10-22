package necessary.class037;

/**
 *ClassName: _7_337
 *Package: necessary.class037
 *Description:创建于 2025/10/22 20:59
 * https://leetcode.cn/problems/house-robber-iii/
 *@Author lyl
 *@Version 1.0
 */
public class _7_337 {
}

class Solution7 {
    //yes:表示在偷头结点的情况下的最大值
    //no:表示在不偷头结点的情况下的最大值
    private int yes, no;

    public int rob (TreeNode root) {
        if (root == null) {
            yes = 0;
            no = 0;
            return 0;
        }
        int aYes = root.val, aNo = 0;
        rob(root.left);
        aYes += no;
        aNo += Math.max(yes , no);
        rob(root.right);
        aYes += no;
        aNo += Math.max(yes , no);
        yes = aYes;
        no = aNo;
        return Math.max(aYes , aNo);
    }


    //理解错误：
//    private int MAXSIZE = 10001;
//    private TreeNode[] queue = new TreeNode[MAXSIZE];
//    private int[] sum = new int[(int) Math.log(MAXSIZE) + 1];
//    private int l, r;
//
//    public int rob (TreeNode root) {
//        l = r = 0;
//        queue[r++] = root;
//        int count = 0;
//        while (l < r) {
//            int size = r - l;
//            for (int i = 0 ; i < size ; i++) {
//                TreeNode cur = queue[l++];
//                sum[count] += cur.val;
//                if (cur.left != null)
//                    queue[r++] = cur.left;
//                if (cur.right != null)
//                    queue[r++] = cur.right;
//            }
//        }
//
//    }
}