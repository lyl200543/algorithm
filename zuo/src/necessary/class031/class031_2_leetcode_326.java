package necessary.class031;

/**
 *ClassName: class031_2_leetcode_326
 *Package: necessary.class031
 *Description:创建于 2025/9/22 20:34
 *判断一个整数是不是3的幂
 *3^19=1162261467  <  2147483647(int最大值)  <3^20=3486784401
 *@Author lyl
 *@Version 1.0
 */
public class class031_2_leetcode_326 {
}

class Solution15 {
    public boolean isPowerOfThree (int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}