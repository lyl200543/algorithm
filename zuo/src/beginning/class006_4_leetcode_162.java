package beginning;

/**
 *ClassName: class006_4_leetcode_162
 *Package: beginning
 *Description:创建于 2025/7/31 21:45
 *4)二分搜索不一定发生在有序数组上(比如寻找峰值问题)
 *@Author lyl
 *@Version 1.0
 */
public class class006_4_leetcode_162 {
}

class Solution {
    public int findPeakElement (int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;
        int left = 1;
        int right = n - 2;
        int mid = 0;
        int ans = - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            int leftnum = nums[mid - 1];
            int rightnum = nums[mid + 1];
            if (nums[mid] > leftnum && nums[mid] > rightnum) {
//                return mid;
                ans = mid;
                break;
            } else if (nums[mid] < leftnum) {
                right = mid - 1;
            } else if (nums[mid] < rightnum) {
                left = mid + 1;
            }
        }
//        return - 1;
        return ans;

    }
}