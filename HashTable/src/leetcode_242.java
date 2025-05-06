import java.util.Arrays;

/**
 *ClassName: leetcode_242
 *Package: PACKAGE_NAME
 *Description:创建于 2025/5/6 20:50
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_242 {
    public static void main (String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isAnagram("rat" , "car"));
    }
}

class Solution1 {
    public boolean isAnagram (String s , String t) {
        //排序+遍历：O(nlogn)

//        if (s == null && t == null)
//            return true;
//        if (s == null || t == null)
//            return false;
//        if (s.length() != t.length())
//            return false;
//        char[] arr1 = s.toCharArray();
//        char[] arr2 = t.toCharArray();
//        Arrays.sort(arr1);
//        Arrays.sort(arr2);
//        for (int i = 0 ; i < s.length() ; i++) {
//            if (arr1[i] != arr2[i])
//                return false;
//        }
//        return true;


        //改进：哈希表（char[26]对应26个字母） O(n)
        //遍历字符串s，在数组对应的元素上+1
        //遍历字符串t，在数组对应的元素上-1
        //判断数组元素是否全为0
        int[] arr = new int[26];
        for (int i = 0 ; i < s.length() ; i++) {
            int c = (int) s.charAt(i);
            arr[c - 'a']++;
        }
        for (int i = 0 ; i < t.length() ; i++) {
            int c = (int) t.charAt(i);
            arr[c - 'a']--;
        }
        for (int i = 0 ; i < 26 ; i++) {
            if (arr[i] != 0)
                return false;
        }
        return true;
    }
}