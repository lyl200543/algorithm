package necessary.class043;

/**
 *ClassName: _2_906
 *Package: necessary.class043
 *Description:创建于 2025/11/30 19:58
 * https://leetcode.cn/problems/super-palindromes/
 *@Author lyl
 *@Version 1.0
 */
public class _2_906 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.superpalindromesInRange("40000000000000000", "50000000000000000"));
    }
}
//数据量为10^18,若从根号x出发，则数据量为10^9,
//若再将1~10^9的数从中间分开，则数据量为10^5
//例如 123 可推出12321/123321，再平方就是原本数据
class Solution2 {
    public int superpalindromesInRange(String left, String right) {
        long start = Long.valueOf(left);
        long end = Long.valueOf(right);
        int count = 0;
        long limit = (long) Math.sqrt((double) end);
        long seed = 1, num = 0;
        do {
            num = evenEnlarge(seed);
            if (check(num * num, start, end)) {
                count++;
            }
            num = oddEnlarge(seed);
            if (check(num * num, start, end)) {
                count++;
            }
            seed++;
        } while (num < limit);
        return count;
    }

    private long evenEnlarge(long seed) {
        long ans = seed;
        while (seed != 0) {
            ans = ans * 10 + seed % 10;
            seed /= 10;
        }
        return ans;
    }

    private long oddEnlarge(long seed) {
        long ans = seed;
        seed /= 10;
        while (seed != 0) {
            ans = ans * 10 + seed % 10;
            seed /= 10;
        }
        return ans;
    }

    private boolean check(long num, long start, long end) {
        if (num < start || num > end) {
            return false;
        }
        return isPalindromic(num);
    }

    //判断是否是回文数
    private boolean isPalindromic(long num) {
        long i = 1;
        while (num / i >= 10) {
            i *= 10;
        }
        while (num >= 10) {
            if (num % 10 != num / i) {
                return false;
            }
            num = (num % i) / 10;
            i /= 100;
        }
        return true;
    }
}
//class Solution2 {
//    public int superpalindromesInRange(String left, String right) {
//        long start = Integer.valueOf(left);
//        long end = Integer.valueOf(right);
//        int count = 0;
//        for (long i = start; i * i <= end; i++) {
//            if (isNum(i) && isNum(i * i)) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    private boolean isNum(long i) {
//        String str = String.valueOf(i);
//        char[] arr = str.toCharArray();
//        int l = 0, r = arr.length - 1;
//        while (l < r && arr[l] == arr[r]) {
//            l++;
//            r--;
//        }
//        if (l >= r) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//}