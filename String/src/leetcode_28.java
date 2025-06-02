import java.util.List;

/**
 *ClassName: leetcode_28
 *Package: PACKAGE_NAME
 *Description:创建于 2025/6/1 20:41
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_28 {
    public static void main (String[] args) {
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.strStr(new String("sadbutsad") , new String("sad")));
    }
}

class Solution4 {
    public int strStr (String haystack , String needle) {
//        if (haystack.length() < needle.length())
//            return - 1;
//        for (int i = 0 ; i < haystack.length() ; i++) {
//            int haystackIndex = i;
//            int needleIndex = 0;
//            while (haystackIndex < haystack.length() && needleIndex < needle.length()) {
//                if (haystack.charAt(haystackIndex) != needle.charAt(needleIndex))
//                    break;
//                haystackIndex++;
//                needleIndex++;
//            }
//            if (needleIndex == needle.length())
//                return i;
//        }
//        return - 1;

        //KMP算法：匹配字符串
        String str = needle + "#" + haystack;
        int[] next = new int[str.length()];
        next[0] = 0;
        for (int i = 1 ; i < str.length() ; i++) {
            int len = next[i - 1];
            while (len > 0 && str.charAt(len) != str.charAt(i)) {
                len = next[len - 1];
            }
            if (str.charAt(len) == str.charAt(i)) {
                next[i] = len + 1;
                if (next[i] == needle.length())
                    return i - needle.length() * 2;
            }
        }
        return - 1;

    }
}