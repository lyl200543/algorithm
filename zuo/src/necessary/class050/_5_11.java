package necessary.class050;

/**
 *ClassName: _5_11
 *Package: necessary.class050
 *Description:创建于 2025/11/26 19:49
 *  https://leetcode.cn/problems/container-with-most-water/
 *@Author lyl
 *@Version 1.0
 */
public class _5_11 {
}

class Solution5 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = (r - l) * Math.min(height[l], height[r]);
        while (l < r) {
            if (height[l] <= height[r]) {
                l++;
            }else{
                r--;
            }
            int sum = (r - l) * Math.min(height[l], height[r]);
            max = Math.max(max, sum);
        }
        return max;
    }
}