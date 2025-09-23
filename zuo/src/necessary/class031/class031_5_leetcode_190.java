package necessary.class031;

/**
 *ClassName: class031_5_leetcode_190
 *Package: necessary.class031
 *Description:创建于 2025/9/23 19:35
 * 颠倒给定的 32 位有符号整数的二进制位
 * 思路：
 * abcdefgh 颠倒    1个交换，2个交换，4个交换...
 * badcfehg  ->  dcbahgfe ->  hgfedcba
 *
 * 用abcdefgh标识不同位置的 1 0
 * (abcdefgh & 10101010)>>1 | (abcdefgh & 01010101)<<1
 *  a0c0e0g0>>1 | 0b0d0f0h>>1
 *  0a0c0e0g | b0d0f0h0 -> badcfehg
 *
 *  (badcfehg & 11001100)>>2 | (badcfehg & 00110011)<<2
 *  ...
 *@Author lyl
 *@Version 1.0
 */
public class class031_5_leetcode_190 {
}

class Solution17 {
    public int reverseBits(int n) {
        //>>> 高位补0
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xffff0000) >>> 16) | ((n & 0x0000ffff) << 16);
        return n;
    }
}