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
        for (int i = 0 ; i < s.length() / 2 ; i++) {
            int len = i + 1;
            int j;
            for (j = i + 1; j + len <= s.length() ; j += len) {
                String s1 = s.substring(0 , i + 1);
                String s2 = s.substring(j , j + len);
                if (! s.substring(0 , i + 1).equals(s.substring(j , j + len)))
                    break;
            }
            if (j >= s.length())
                return true;
        }
        return false;
    }
}