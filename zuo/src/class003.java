/**
 *ClassName: class003
 *Package: PACKAGE_NAME
 *Description:创建于 2025/7/24 21:18
 *如何打印一个数字的二进制表示（以int为例）
 *@Author lyl
 *@Version 1.0
 */
public class class003 {
    public static void main (String[] args) {
        printBinary(10);
    }

    public static void printBinary (int x) {
        for (int i = 31 ; i >= 0 ; i--) {
            // 不可以改成 :
            // System.out.print((a & (1 << i)) == 1 ? "1" : "0");
            // 因为a如果第i位有1，那么(a & (1 << i))是2的i次方，而不一定是1
            // 比如，a = 0010011
            // a的第0位是1，第1位是1，第4位是1
            // (a & (1<<4)) == 16（不是1），说明a的第4位是1状态
            System.out.println((x & (1 << i)) == 0 ? 0 : 1);

        }
    }
}
