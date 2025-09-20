package necessary.class030;

/**
 *ClassName: class030_1_newcoder_getMax
 *Package: necessary
 *Description:创建于 2025/9/20 20:50
 *不用任何判断语句和比较操作，返回两个数的最大值
 *@Author lyl
 *@Version 1.0
 */
public class class030_1_newcoder_getMax {
}

class Solution9 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 获取最大值
     * @param a int整型
     * @param b int整型
     * @return int整型
     */
    public int getMax (int a , int b) {
        // write code here
        //a，b为最大和最小值时会溢出
        int c = a - b;
        int cs = sign(c);
        int as = sign(a);
        int bs = sign(b);
        int diffAb = as ^ bs;
        int sameAb = flip(diffAb);
        int returnA = diffAb * as + sameAb * cs;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    //非负数返回1
    //负数返回0
    public static int sign (int x) {
        //>>>：最高位补0
        return flip(x >>> 31);
    }

    public static int flip (int x) {
        return x ^ 1;
    }
}