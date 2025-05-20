import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 *ClassName: leetcode_454
 *Package: PACKAGE_NAME
 *Description:创建于 2025/5/15 21:36
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_454 {
    @Test
    public void test () {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.fourSumCount(new int[]{0 , 1 , - 1} , new int[]{- 1 , 1 , 0} , new int[]{0 , 0 , 1} , new int[]{- 1 , 1 , 1}));

    }
}

//key放a和b两数之和，value 放a和b两数之和出现的次数
class Solution5 {
    public int fourSumCount (int[] nums1 , int[] nums2 , int[] nums3 , int[] nums4) {
        int n = nums1.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                int sum = nums1[i] + nums2[j];
                map.put(sum , map.getOrDefault(sum , 0) + 1);
            }
        }
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                int sum = nums3[i] + nums4[j];
                count += map.getOrDefault(- sum , 0);
            }
        }
        return count;
    }
}