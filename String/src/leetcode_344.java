/**
 *ClassName: leetcode_344
 *Package: PACKAGE_NAME
 *Description:创建于 2025/5/28 21:31
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_344 {
}

class Solution1 {
    public void reverseString (char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}