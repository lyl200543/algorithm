package necessary.class030;

/**
 *ClassName: class030_2_leetcode_268
 *Package: necessary
 *Description:创建于 2025/9/20 21:01
 *给定一个包含 [0, n] 中 n 个数的数组 nums
 *找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *@Author lyl
 *@Version 1.0
 */
public class class030_2_leetcode_268 {
}

class Solution10 {
    public int missingNumber (int[] nums) {
        int eor1 = 0;
        int eor2 = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            eor1 ^= i;
            eor2 ^= nums[i];
        }
        eor1 ^= nums.length;
        return eor1 ^ eor2;
    }
}