package necessary.class031;

/**
 *ClassName: class031_4_leetcode_201
 *Package: necessary.class031
 *Description:创建于 2025/9/22 20:56
 * 给你两个整数 left 和 right ，表示区间 [left, right]
 * 返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）
 *
 * 思路：
 * 01001010  right
 * left < right 时，right-1 --> 01001001 & 01001010
 * 01001000  不管中间有多少个数，相当于right -=right & (-right)
 * 再将left与right比大小，重复以上操作
 *@Author lyl
 *@Version 1.0
 */
public class class031_4_leetcode_201 {
}

class Solution16 {
    public int rangeBitwiseAnd (int left , int right) {
        while (left < right) {
            right = right - (right & (- right));
        }
        return right;
    }
}