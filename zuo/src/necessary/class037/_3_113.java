package necessary.class037;

import java.util.ArrayList;
import java.util.List;

/**
 *ClassName: _3_113
 *Package: necessary.class037
 *Description:创建于 2025/10/18 20:34
 * https://leetcode.cn/problems/path-sum-ii/
 *@Author lyl
 *@Version 1.0
 */
public class _3_113 {
}

class Solution3 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root!=null) {
            List<Integer> path=new ArrayList<>();
            recursive(root,targetSum,0,path,ans);
        }
        return ans;
    }

    private void recursive (TreeNode cur , int aim , int sum , List<Integer> path , List<List<Integer>> ans) {
        if(cur==null)
            return;
        if(cur.left==null && cur.right==null && aim==cur.val+sum){
            path.add(cur.val);
            ans.add(List.copyOf(path));
            path.removeLast();
        }else{
            path.add(cur.val);
            if(cur.left!=null)
                recursive(cur.left,aim,sum+cur.val,path,ans);
            if(cur.right!=null)
                recursive(cur.right,aim,sum+cur.val,path,ans);
            path.removeLast();
        }
    }
}