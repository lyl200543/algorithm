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
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.permute(new int[]{1 , 2 , 3}));
    }
}

class Solution3 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(nums , 0 , ans);
        return ans;

    }

    private void f(int[] nums , int i , List<List<Integer>> ans) {
        if (i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums)
                list.add(n);
            ans.add(list);
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(nums , i , j);
                f(nums , i + 1 , ans);
                swap(nums , i , j);
            }
        }
    }

    private static void swap(int[] nums , int i , int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    //自己的实现：
    //    public List<List<Integer>> permute(int[] nums) {
    //        List<List<Integer>> ans = new ArrayList<>();
    //        recursive(nums , 0 , new ArrayList<>() , ans);
    //        return ans;
    //    }
    //
    //    private void recursive(int[] nums , int i , ArrayList<Integer> path , List<List<Integer>> ans) {
    //        if (i >= nums.length) {
    //            List<Integer> copy = new ArrayList<>(path);
    //            ans.add(copy);
    //        } else {
    //            for (int j = 0; j <= i; j++) {
    //                path.add(j , nums[i]);
    //                recursive(nums , i + 1 , path , ans);
    //                path.remove(j);
    //            }
    //        }
    //    }
}