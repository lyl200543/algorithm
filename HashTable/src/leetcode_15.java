import javax.swing.*;
import java.util.*;

/**
 *ClassName: leetcode_15
 *Package: PACKAGE_NAME
 *Description:创建于 2025/5/21 21:34
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_15 {
}

class Solution7 {
    public List<List<Integer>> threeSum (int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        List<List<Integer>> lists = new ArrayList<>();
//        for (int i = 0 ; i < nums.length ; i++) {
//            set.add(nums[i]);
//        }
//        for (int i = 0 ; i < nums.length ; i++) {
//            for (int j = i + 1 ; j < nums.length ; j++) {
//                if (set.contains(- (nums[i] + nums[j]))) {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(nums[i]);
//                    list.add(nums[j]);
//                    list.add(- (nums[i] + nums[j]));
//                    lists.add(list);
//                }
//            }
//        }
//        return lists;


        //使用哈希法，去重操作交麻烦（未尝试）
        //双指针法：
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; i++) {
            //剪枝操作
            if (nums[i] > 0)
                break;
            //对a去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0)
                    right--;
                else if (sum < 0)
                    left++;
                else {
                    lists.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    left++;
                    right--;
                    //b去重
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    //c去重
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                }
            }
        }
        return lists;

    }
}