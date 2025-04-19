import org.junit.Test;

import java.util.concurrent.LinkedTransferQueue;

/**
 * ClassName: leetcode_209
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/19 20:47
 *
 * @Author lyl
 * @Version 1.0
 */
public class leetcode_209 {
}

//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
// 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其
//长度。如果不存在符合条件的子数组，返回 0 。
//
//
//
// 示例 1：
//
//
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//
//
// 示例 2：
//
//
//输入：target = 4, nums = [1,4,4]
//输出：1
//
//
// 示例 3：
//
//
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= target <= 10⁹
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁴
//
//
//
//
// 进阶：
//
//
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
//
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 2436 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution4 {
    public int minSubArrayLen (int target , int[] nums) {
        //看错条件：是大于等于，看成等于

//        int min = nums.length + 1;
//        int value = nums[0];
//        int front = 0;
//        int rear = 0;
//        while (rear < nums.length) {
//            if (value < target) {
//                rear++;
//                if (rear >= nums.length)
//                    break;
//                value += nums[rear];
//            } else if (value > target) {
//                value -= nums[front];
//                front++;
//            } else {
//                int tmp = rear - front + 1;
//                if (tmp < min)
//                    min = tmp;
//                if (rear < nums.length - 1) {
//                    rear++;
//                    value += nums[rear];
//                } else break;
//            }
//        }
//        return min == nums.length + 1 ? 0 : min;


        //滑动窗口法：
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0 ; right < nums.length ; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result , right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
