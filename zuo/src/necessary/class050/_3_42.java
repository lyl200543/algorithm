package necessary.class050;

/**
 *ClassName: _3_42
 *Package: necessary.class050
 *Description:创建于 2025/11/25 22:19
 * https://leetcode.cn/problems/trapping-rain-water/description/
 * 双指针：单调性
 *@Author lyl
 *@Version 1.0
 */
public class _3_42 {
}
class Solution3 {
    public int trap(int[] height) {
        int n = height.length;
        int l = 1, r = n - 2;
        int lmax = height[0], rmax = height[n - 1];
        int ans = 0;
        while (l <= r) {
            if (lmax <= rmax) {
                ans += Math.max(lmax - height[l], 0);
                lmax = Math.max(lmax, height[l]);
                l++;
            } else {
                ans += Math.max(rmax - height[r], 0);
                rmax = Math.max(rmax, height[r]);
                r--;
            }
        }
        return ans;
    }
}

//常规解法：
//class Solution3 {
//    public int trap(int[] height) {
//        int n = height.length;
//        int[] lmax = new int[n];
//        int[] rmax = new int[n];
//        lmax[0] = height[0];
//        for (int i = 1; i < n; i++) {
//            lmax[i] = Math.max(lmax[i - 1], height[i]);
//        }
//        rmax[n - 1] = height[n - 1];
//        for (int i = n - 2; i >= 0; i--) {
//            rmax[i] = Math.max(rmax[i + 1], height[i]);
//        }
//        int ans = 0;
//        for (int i = 1; i < n - 1; i++) {
//            ans += Math.max(0, Math.min(lmax[i - 1], rmax[i + 1]) - height[i]);
//        }
//        return ans;
//    }
//}