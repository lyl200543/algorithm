package necessary.class063;

import java.util.Arrays;
import java.util.Map;

/**
 *ClassName: _3_1755
 *Package: necessary.class063
 *Description:创建于 2025/12/6 21:16
 * https://leetcode.cn/problems/closest-subsequence-sum/
 *@Author lyl
 *@Version 1.0
 */
public class _3_1755 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.minAbsDifference(new int[]{5, -7, 3, 5}, 6));
    }
}

//优化：
class Solution3 {
    private int MAXN = 1 << 20;
    private int[] lsum = new int[MAXN];
    private int[] rsum = new int[MAXN];
    private int fill;

    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        //1.优化：去除大于全部正整数和小于全部负数的情况
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                sum1 += nums[i];
            }
            if (nums[i] < 0) {
                sum2 += nums[i];
            }
        }
        if (sum1 <= goal) {
            return goal - sum1;
        }
        if (sum2 >= goal) {
            return sum2 - goal;
        }
        Arrays.sort(nums);
        fill = 0;
        collect(0, n >> 1, nums, 0, lsum);
        int lsize = fill;
        fill = 0;
        collect(n >> 1, n, nums, 0, rsum);
        int rsize = fill;
        Arrays.sort(lsum, 0, lsize);
        Arrays.sort(rsum, 0, rsize);
        int ans = Math.abs(goal);
        for (int i = 0, j = rsize - 1; i < lsize; i++) {
            while (j > 0 && Math.abs(lsum[i] + rsum[j] - goal) >= Math.abs(lsum[i] + rsum[j - 1] - goal)) {
                j--;
            }
            ans = Math.min(ans, Math.abs(lsum[i] + rsum[j] - goal));
        }
        return ans;
    }

    private void collect(int start, int end, int[] nums, int sum, int[] ans) {
        if (start == end) {
            ans[fill++] = sum;
            return;
        }
        //2.优化：分组优化，相同的数字为一组，二叉树变为多叉树，减小深度
        int j = start + 1;
        while (j < end && nums[j] == nums[start]) {
            j++;
        }
        for (int i = 0; i <= j - start; i++) {
            collect(j, end, nums, sum + i * nums[start], ans);
        }
    }
}


//模板：
//class Solution {
//    public int minAbsDifference(int[] nums, int goal) {
//        int n = nums.length;
//        int m = 1 << (n / 2 + 1);
//        int[] lsum = new int[m];
//        int[] rsum = new int[m];
//        int lsize = f(0, n >> 1, nums, 0, lsum, 0);
//        int rsize = f(n >> 1, n, nums, 0, rsum, 0);
//        Arrays.sort(lsum, 0, lsize);
//        Arrays.sort(rsum, 0, rsize);
//        int ans = Integer.MAX_VALUE;
//        for (int i = 0, j = rsize - 1; i < lsize;) {
//            if (j > 0 && Math.abs(lsum[i] + rsum[j] - goal) >= Math.abs(lsum[i] + rsum[j - 1] - goal)) {
//                j--;
//            } else {
//                i++;
//            }
//            ans = Math.min(ans, Math.abs(lsum[i] + rsum[j] - goal));
//        }
//        return ans;
//    }
//
//    private int f(int start, int end, int[] nums, int sum, int[] ans, int i) {
//        if (start == end) {
//            ans[i++] = sum;
//            return i;
//        }
//        i = f(start + 1, end, nums, sum + nums[start], ans, i);
//        i = f(start + 1, end, nums, sum, ans, i);
//        return i;
//    }
//}