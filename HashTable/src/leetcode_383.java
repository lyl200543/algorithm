import java.util.HashMap;

/**
 *ClassName: leetcode_383
 *Package: PACKAGE_NAME
 *Description:创建于 2025/5/21 21:15
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_383 {
}


class Solution6 {
    public boolean canConstruct (String ransomNote , String magazine) {
//        boolean flag = true;
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0 ; i < magazine.length() ; i++) {
//            map.put(magazine.charAt(i) , map.getOrDefault(magazine.charAt(i) , 0) + 1);
//        }
//        for (int i = 0 ; i < ransomNote.length() ; i++) {
//            Character ch = ransomNote.charAt(i);
//            if (map.get(ch) == null || map.get(ch) == 0) {
//                flag = false;
//                break;
//            }
//            map.put(ch , map.get(ch) - 1);
//        }
//        return flag;


        //使用map的空间消耗要比数组大一些的，因为map要维护红黑树或者哈希表，而且还要做哈希函数，是费时的！
        //数据量大的话就能体现出来差别了。 所以数组更加简单直接有效！
        if (ransomNote.length() > magazine.length())
            return false;
        int[] arr = new int[26];
        for (char c : magazine.toCharArray()) {
            arr[c - 'a'] += 1;
        }
        for (char c : ransomNote.toCharArray()) {
            if (arr[c - 'a'] == 0) {
                return false;
            }
            arr[c - 'a'] -= 1;
        }
        return true;
    }
}