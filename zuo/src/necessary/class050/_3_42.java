package necessary.class050;

/**
 *ClassName: _3_42
 *Package: necessary.class050
 *Description:创建于 2025/11/25 22:19
 *@Author lyl
 *@Version 1.0
 */
public class _3_42 {
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