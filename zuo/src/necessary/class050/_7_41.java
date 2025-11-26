package necessary.class050;

/**
 *ClassName: _7_61
 *Package: necessary.class050
 *Description:创建于 2025/11/26 21:32
 * https://leetcode.cn/problems/first-missing-positive/description/
 * 难！！！！！！！！
 * l:l左边的数组上都满足i上放i+1，第一个不满足的下标+2就是缺失的最小正整数
 * r:垃圾区，放置的都是不满足i上放i+1的下标
 *@Author lyl
 *@Version 1.0
 */
public class _7_41{
}
class Solution7 {
    public int firstMissingPositive(int[] nums) {
        int l = 0, r = nums.length;
        while (l < r) {
            if (nums[l] == l + 1) {
                l++;
            } else if (nums[l] <= l || nums[l] > r || nums[nums[l] - 1] == nums[l]) {
                swap(nums, l, --r);
            } else {
                //l<nums[l]<=r ,nums[nums[l]-1]!=nums[l]
                swap(nums, l, nums[l] - 1);
            }
        }
        return l + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}