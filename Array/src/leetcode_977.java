import java.util.ArrayList;

import static java.util.Arrays.sort;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.sort;

/**
 * ClassName: leetcode_977
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/18 20:24
 *
 * @Author lyl
 * @Version 1.0
 */
public class leetcode_977 {
}

//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100]
//
// 示例 2：
//
//
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 已按 非递减顺序 排序
//
//
//
//
// 进阶：
//
//
// 请你设计时间复杂度为 O(n) 的算法解决本问题
//
//
// Related Topics 数组 双指针 排序 👍 1098 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


class Solution3 {
    public int[] sortedSquares (int[] nums) {
        //暴力法：

//        for (int i = 0 ; i < nums.length ; i++) {
//            nums[i] = nums[i] * nums[i];
//        }
//        sort(nums);
//        return nums;

        //双指针法：
        for (int i = 0 ; i < nums.length ; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int[] arr = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int k = nums.length - 1;
        while (left <= right) {
            if (nums[left] < nums[right])
                arr[k--] = nums[right--];
            else
                arr[k--] = nums[left++];
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
