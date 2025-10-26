package necessary.class038;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *ClassName: _4_47
 *Package: necessary.class038
 *Description:创建于 2025/10/26 21:14
 *  https://leetcode.cn/problems/permutations-ii/
 *@Author lyl
 *@Version 1.0
 */
public class _4_47 {
}

class Solution4 {
    public List<List<Integer>> permuteUnique(int[] nums) {
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
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                if (!set.contains(nums[j])) {
                    set.add(nums[j]);
                    swap(nums , i , j);
                    f(nums , i + 1 , ans);
                    swap(nums , i , j);
                }
            }
        }
    }

    private static void swap(int[] nums , int i , int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    //想得太浅了
    //    public List<List<Integer>> permuteUnique(int[] nums) {
    //        Set<List<Integer>> set = new HashSet<>();
    //        f(nums , 0 , set);
    //        return new ArrayList<>(set);
    //    }
    //
    //    private void f(int[] nums , int i , Set<List<Integer>> ans) {
    //        if (i == nums.length) {
    //            List<Integer> list = new ArrayList<>();
    //            for (int n : nums)
    //                list.add(n);
    //            ans.add(list);
    //        } else {
    //            for (int j = i; j < nums.length; j++) {
    //                swap(nums , i , j);
    //                f(nums , i + 1 , ans);
    //                swap(nums , i , j);
    //            }
    //        }
    //    }
    //
    //    private static void swap(int[] nums , int i , int j) {
    //        int tmp = nums[i];
    //        nums[i] = nums[j];
    //        nums[j] = tmp;
    //    }

}