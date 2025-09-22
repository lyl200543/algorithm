package necessary.class031;

/**
 *ClassName: class031_1_leetcode_231
 *Package: necessary.class031
 *Description:创建于 2025/9/22 20:30
 *判断是否是2的幂
 *@Author lyl
 *@Version 1.0
 */
public class class031_1_leetcode_231 {
}

class Solution14 {
    public boolean isPowerOfTwo (int n) {
        return n > 0 && n == (n & (- n));
    }
}
