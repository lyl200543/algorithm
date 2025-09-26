package necessary;

/**
 *ClassName: class033_leetcode_29
 *Package: necessary
 *Description:创建于 2025/9/26 21:28
 *位运算实现加减乘除（计算机底层实现）
 *@Author lyl
 *@Version 1.0
 */
public class class033_leetcode_29 {
    public static int add (int a , int b) {
        int ans = a;
        while (b != 0) {
            ans = a ^ b;
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }

    public static int subtract (int a , int b) {
        return add(a , neg(b));
    }

    public static int neg (int n) {
        return add(~ n , 1);
    }

    public static int multiply (int a , int b) {
        //类似  57         110100
        //   * 21         011010
        // ---------    ----------
        //     57         000000
        // + 114         110100
        //----------     ...
        //   1197
        int ans = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = add(ans , a);
            }
            a = a << 1;
            b = b >>> 1;
        }
        return ans;
    }

    //注意：最小整数没有对应的相反数
    //不考虑最小整数的情况：
    public static int division (int a , int b) {
        //280/25=11...5
        //280=25*2^3 + 25*2^1 + 25*2^0  -->11
        int ans = 0;
        int x = a > 0 ? a : neg(a);
        int y = b > 0 ? b : neg(b);
        //符号位不考虑
        for (int i = 30 ; i >= 0 ; i = subtract(i , 1)) {
            //y<<i有可能溢出
            if ((x >>> i) >= y) {
                ans |= (1 << i);
                x = subtract(x , y << i);
            }
        }
        return (a < 0) ^ (b < 0) ? neg(ans) : ans;
    }
}

class Solution19 {
    public static int min = Integer.MIN_VALUE;

    //考虑最小整数：
    public int divide (int dividend , int divisor) {
        if (dividend == min && divisor == min)
            return 1;
        if (dividend != min && divisor != min)
            return division(dividend , divisor);
        if (divisor == min)
            return 0;
        if (divisor == neg(1))
            return Integer.MAX_VALUE;
        //其他情况：dividend为最小整数，divisor不是最小整数，也不是-1
        if (divisor > 0) {
            dividend = add(dividend , divisor);
            return division(dividend , divisor) - 1;
        } else {
            dividend = subtract(dividend , divisor);
            return division(dividend , divisor) + 1;
        }

    }

    //不考虑最小整数的情况：
    public static int division (int a , int b) {
        //280/25=11...5
        //280=25*2^3 + 25*2^1 + 25*2^0  -->11
        int ans = 0;
        int x = a > 0 ? a : neg(a);
        int y = b > 0 ? b : neg(b);
        //符号位不考虑
        for (int i = 30 ; i >= 0 ; i = subtract(i , 1)) {
            //y<<i有可能溢出
            if ((x >>> i) >= y) {
                ans |= (1 << i);
                x = subtract(x , y << i);
            }
        }
        return (a < 0) ^ (b < 0) ? neg(ans) : ans;
    }

    public static int subtract (int a , int b) {
        return add(a , neg(b));
    }

    public static int neg (int n) {
        return add(~ n , 1);
    }

    public static int add (int a , int b) {
        int ans = a;
        while (b != 0) {
            ans = a ^ b;
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }
}