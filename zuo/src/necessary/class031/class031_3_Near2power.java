package necessary.class031;

/**
 *ClassName: class031_3_Near2power
 *Package: necessary.class031
 *Description:创建于 2025/9/22 20:42
 * // 已知n是非负数
 * // 返回大于等于n的最小的2某次方
 * // 如果int范围内不存在这样的数，返回整数最小值
 *
 * 思路：
 * 00100001  --》 01000000
 * >>1
 * 00010000  |   00110001
 * >>2
 * 00001100  |   00111101
 * ....
 *@Author lyl
 *@Version 1.0
 */
public class class031_3_Near2power {
    public static final int near2power (int n) {
        if (n <= 0)
            return 1;
        //处理n本身就是2的幂的情况
        n = n - 1;

        n = n | (n >> 1);
        n = n | (n >> 2);
        n = n | (n >> 4);
        n = n | (n >> 8);
        n = n | (n >> 16);
        return n + 1;
    }

}
