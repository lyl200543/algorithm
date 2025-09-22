package necessary.class030;

import java.util.Arrays;

/**
 *ClassName: class030_5_leetcode_137
 *Package: necessary.class030
 *Description:创建于 2025/9/20 21:34
 *给你一个整数数组 nums ，除某个元素出现 k次(k<m) 外，其余每个元素都恰出现 m次
 *请你找出并返回那个只出现了K次的元素
 *@Author lyl
 *@Version 1.0
 */
public class class030_5_leetcode_137 {
}

class Solution13 {
    public static int m = 3;

    public int singleNumber (int[] nums) {
        int[] bits = new int[32];
        Arrays.fill(bits , 0);
        int ans = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            for (int j = 0 ; j < bits.length ; j++) {
                bits[j] += (nums[i] >> j) & 1;
            }
        }
        for (int i = 0 ; i < bits.length ; i++) {
            if (bits[i] % m != 0) {
                ans = ans ^ (1 << i);
            }
        }
        return ans;
    }
}