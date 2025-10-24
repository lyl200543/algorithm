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
    public static void main (String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.subsetsWithDup(new int[]{1 , 2 , 2}));

    }
}

class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return subarray(nums,0);
    }

    private List<List<Integer>> subarray (int[] nums , int start) {
        if(start >= nums.length){
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            return ans;
        }
        List<List<Integer>> ans=new ArrayList<>();
        int val=nums[start];
        int end=start+1;
        while(end < nums.length && nums[end] == val){
            end+=1;
        }
        List<List<Integer>> lists = subarray(nums , end);
        ans.addAll(lists);
        for (int i = 0 ; i < end - start ; i++) {
            lists.forEach(list->list.add(val));
            ans.addAll(lists);
        }
        return ans;
    }


//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        if (nums.length == 0) {
//            List<List<Integer>> ans = new ArrayList<>();
//            ans.add(new ArrayList<>());
//            return ans;
//        }
//        List<List<Integer>> ans=new ArrayList<>();
//        Set<List<Integer>> set = new HashSet<>();
//        int[] subnums=new int[nums.length-1];
//        System.arraycopy(nums,1,subnums,0,subnums.length);
//        List<List<Integer>> lists = subsetsWithDup(subnums);
//        for (List<Integer> list:lists){
//            List<Integer> copy=new ArrayList<>(list);
//            set.add(copy);
//            copy.add(nums[0]);
//            copy.sort((a,b)->a-b);
//            set.add(copy);
//        }
//        ans.addAll(set);
//        return ans;
//    }
}