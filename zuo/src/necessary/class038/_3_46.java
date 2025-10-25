package necessary.class038;

import java.util.ArrayList;
import java.util.List;

/**
 *ClassName: _3_46
 *Package: necessary.class038
 *Description:创建于 2025/10/25 21:38
 * https://leetcode.cn/problems/permutations/
 *@Author lyl
 *@Version 1.0
 */
public class _3_46 {
}

class Solution3 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        recursive(nums,0,new ArrayList<>(),ans);
        return ans;
    }

    private void recursive (int[] nums , int i , ArrayList<Integer> path , List<List<Integer>> ans) {
        if(i>=nums.length){
            List<Integer> copy=new ArrayList<>(path);
            ans.add(copy);
        }
        for (int j = 0 ; j <= i ; j++) {
            path.add(j,nums[i]);
            recursive(nums,i+1,path,ans);
        }
    }
}