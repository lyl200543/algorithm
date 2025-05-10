import java.util.ArrayList;
import java.util.HashSet;

/**
 *ClassName: leetcode_349
 *Package: PACKAGE_NAME
 *Description:创建于 2025/5/8 21:05
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_349 {
}

class Solution2 {
    public int[] intersection (int[] nums1 , int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        for (int i = 0 ; i < nums1.length ; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0 ; i < nums2.length ; i++) {
            if (set.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }
        int[] arr = new int[resultSet.size()];
        int j = 0;
        for (int i : resultSet) {
            arr[j++] = i;
        }
        return arr;
    }

}