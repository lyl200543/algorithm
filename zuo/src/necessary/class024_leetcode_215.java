package necessary;

/**
 *ClassName: class024_leetcode_215
 *Package: necessary
 *Description:创建于 2025/9/11 18:46
 *随机选择算法：
 *类似快速排序，但是只需要处理一边
 *最好情况为O(n),最坏情况为O(n^2)
 *期望为O(n)
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 :
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 提示：
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *@Author lyl
 *@Version 1.0
 */
public class class024_leetcode_215 {
}

class Solution4 {
    public int findKthLargest(int[] nums, int k) {
        int ans = 0;
        int location = nums.length - k;
        for (int l = 0, r = nums.length - 1; l <= r;) {
            int x = nums[l + (int) (Math.random() * (r - l + 1))];
            partition(nums, l, r, x);
            if (location < first) {
                r = first - 1;

            } else if (location > last) {
                l = last + 1;
            } else {
                ans = nums[first];
                break;
            }
        }
        return ans;
    }

    public static int first;
    public static int last;

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void partition(int[] nums, int l, int r, int x) {
        int i = l, a = l, b = r;
        while (i <= b) {
            if (nums[i] < x) {
                swap(nums, a++, i++);

            } else if (nums[i] > x) {
                swap(nums, b--, i);
            } else {
                i++;
            }
        }
        first = a;
        last = b;
    }
}