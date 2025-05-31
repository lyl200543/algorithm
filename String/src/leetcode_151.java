/**
 *ClassName: leetcode_151
 *Package: PACKAGE_NAME
 *Description:创建于 2025/5/31 20:37
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_151 {
    public static void main (String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.reverseWords(new String("a good   example")));
    }
}

class Solution3 {
    public String reverseWords (String s) {
//        String[] str = s.trim().split(" +");
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = str.length - 1 ; i >= 0 ; i--) {
//            stringBuilder.append(str[i].trim());
//            if (i != 0) {
//                stringBuilder.append(" ");
//            }
//        }
//        return stringBuilder.toString();

        //双指针法：
//        StringBuilder str = new StringBuilder();
//        int left = s.length() - 1;
//        while (left >= 0 && s.charAt(left) == ' ') {
//            left--;
//        }
//        int right = left + 1;
//        while (left >= 0) {
//            while (left >= 0 && s.charAt(left) != ' ') {
//                left--;
//            }
//            str.append(s.substring(left , right));
//            while (left >= 0 && s.charAt(left) == ' ') {
//                left--;
//            }
//            right = left + 1;
//        }
//        return str.toString().trim();


        //改进：
        //去除多余空格
        StringBuilder sb = removeSpaces(s);
        //反转整个字符串
        reverseString(sb , 0 , sb.length() - 1);
        //反转每个单词
        reverseEach(sb);
        return sb.toString();
    }

    StringBuilder removeSpaces (String s) {
        int left = 0;
        int right = s.length() - 1;
        while (s.charAt(left) == ' ')
            left++;
        while (s.charAt(right) == ' ')
            right--;
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            if (s.charAt(left) != ' ' || sb.charAt(sb.length() - 1) != ' ')
                sb.append(s.charAt(left));
            left++;
        }
        return sb;
    }

    void reverseString (StringBuilder sb , int start , int end) {
        while (start < end) {
            char tmp = sb.charAt(start);
            sb.setCharAt(start , sb.charAt(end));
            sb.setCharAt(end , tmp);
            start++;
            end--;
        }
    }

    void reverseEach (StringBuilder sb) {
        int start = 0;
        int end = start + 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ')
                end++;
            reverseString(sb , start , end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}