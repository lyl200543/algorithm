package necessary.class030;

/**
 *ClassName: class030_3_leetcode_136
 *Package: necessary.class030
 *Description:创建于 2025/9/20 21:18
 *数组中1种数出现了奇数次，其他的数都出现了偶数次
 *返回出现了奇数次的数
 *@Author lyl
 *@Version 1.0
 */
public class class030_3_leetcode_136 {
}

class Solution11 {
    public int singleNumber (int[] nums) {
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        return eor;
    }
}