package necessary.class030;

/**
 *ClassName: class030_4_leetcode_260
 *Package: necessary.class030
 *Description:创建于 2025/9/20 21:20
 *给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次
 *找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 *
 *提示：Brian Kernighan算法
 * n & (-n) 为 n 中从右往左第一次出现1的结果
 * 00110100  --》 00000100
 * -n --》 ~n+1
 *@Author lyl
 *@Version 1.0
 */
public class class030_4_leetcode_260 {
}

class Solution12 {
    public int[] singleNumber (int[] nums) {
        int eor1 = 0, eor2 = 0;
        for (int num : nums) {
            eor1 ^= num;
        }
        //a!=b  a^b一定有某一位上是1，根据这个分情况找出
        int bit = eor1 & (- eor1);
        for (int num : nums) {
            if ((num & bit) == 0) {
                eor2 ^= num;
            }
        }
        return new int[]{eor2 , eor1 ^ eor2};
    }
}