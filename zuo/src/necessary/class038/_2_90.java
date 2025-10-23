package necessary.class038;

import java.util.*;

/**
 *ClassName: _2_90
 *Package: necessary.class038
 *Description:创建于 2025/10/23 21:40
 * https://leetcode.cn/problems/subsets-ii/
 *@Author lyl
 *@Version 1.0
 */
public class _2_90 {
}

class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length==0)
            return new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int[] subnums=new int[nums.length-1];
        System.arraycopy(nums,1,subnums,0,subnums.length);
        List<List<Integer>> lists = subsetsWithDup(subnums);
        for (List<Integer> list:lists){
            set.add(list);
            list.add(nums[0]);
            set.add(list);
        }
        ans.addAll(set);
        return ans;
    }
}