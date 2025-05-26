import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *ClassName: leetcode_18
 *Package: PACKAGE_NAME
 *Description:创建于 2025/5/26 21:20
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_18 {
}

class Solution8 {
    public List<List<Integer>> fourSum (int[] nums , int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] > target)
                return lists;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int goal = target - nums[i];
            for (int j = i + 1 ; j < nums.length ; j++) {
                if (nums[j] > goal)
                    return lists;
                if (j > (i + 1) && nums[j] == nums[j - 1])
                    continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[j] + nums[left] + nums[right];
                    if (sum < goal)
                        left++;
                    else if (sum > goal)
                        right--;
                    else {
                        lists.add(Arrays.asList(nums[j] , nums[left] , nums[right]));
                        left++;
                        right--;
                        if (left < right && nums[left] == nums[left - 1])
                            left++;
                        if (left < right && nums[right] == nums[right + 1])
                            left--;
                    }
                }
            }
        }
        return lists;
    }
}