/**
 *ClassName: leetcode_459
 *Package: PACKAGE_NAME
 *Description:创建于 2025/6/3 21:34
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_459 {
    public static void main (String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.repeatedSubstringPattern(new String("abab")));
    }
}

class Solution5 {
    public boolean repeatedSubstringPattern (String s) {
        //暴力解法：
//        for (int i = 0 ; i < s.length() / 2 ; i++) {
//            int len = i + 1;
//            int j;
//            for (j = i + 1; j + len <= s.length() ; j += len) {
//                String s1 = s.substring(0 , i + 1);
//                String s2 = s.substring(j , j + len);
//                if (! s.substring(0 , i + 1).equals(s.substring(j , j + len)))
//                    break;
//            }
//            if (j >= s.length())
//                return true;
//        }
//        return false;


        //移动匹配：
        //如果s可由子串拼接而成，则s+s,再去掉首尾得到的newstr中一定包含s

//        if (s.length() <= 1)
//            return false;
//        String newstr = s.concat(s).substring(1 , 2 * s.length() - 1);
//        return newstr.contains(s);


        //KMP算法：
        //充分条件：如果字符串s是由重复子串组成的，那么它的最长相等前后缀不包含的子串一定是s的最小重复子串。
        //必要条件：如果字符串s的最长相等前后缀不包含的子串是s的最小重复子串，那么s必然是由重复子串组成的。
        //推得：当字符串s的长度可以被其最长相等前后缀不包含的子串的长度整除时，不包含的子串就是s的最小重复子串。


        int[] next = new int[s.length()];
        next[0] = 0;
        for (int i = 1 ; i < s.length() ; i++) {
            int len = next[i - 1];
            while (len > 0 && s.charAt(i) != s.charAt(len)) {
                len = next[len - 1];
            }
            if (s.charAt(i) == s.charAt(len))
                next[i] = len + 1;
        }
        int sonlen = s.length() - next[s.length() - 1];
        if (next[s.length() - 1] > 0 && s.length() % sonlen == 0)
            return true;
        return false;
    }
}