package necessary;


/**
 *ClassName: class041_leetcode_878
 *Package: necessary
 *Description:创建于 2025/11/13 20:45
 *  https://leetcode.cn/problems/nth-magical-number/
 *  思路：
 *  1）确定神奇数字的范围：（1，n*min(a,b)）
 *  2）使用二分法
 *  3）对左边通过 m/a + m/b - m/[a,b] 判断是否包含n个神奇数字
 *  4）包含则往左边二分，不包含则往右边二分
 *@Author lyl
 *@Version 1.0
 */
public class class041_leetcode_878 {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        System.out.println(solution10.nthMagicalNumber(1000000000, 40000, 40000));
    }
}

class Solution10 {
    public int nthMagicalNumber(int n, int a, int b) {
        long x = gcd(a, b);
        long y = a / x * b;
        long l = 0;
        long r = (long) Math.min(a, b) * n;
        long ans = 0;
        while (l <= r) {
            long m = (l + r) / 2;
            if (m / a + m / b - m / y >= n) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return (int) (ans % 1000000007);
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}