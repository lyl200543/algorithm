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
    public static void main (String[] args) {
        int[] nums = new int[]{4 , - 9 , - 2 , - 2 , - 7 , 9 , 9 , 5 , 10 , - 10 , 4 , 5 , 2 , - 4 , - 2 , 4 , - 9 , 5};
        Solution8 solution8 = new Solution8();
        System.out.println(solution8.fourSum(nums , - 13));
    }
}

class Solution8 {
    public List<List<Integer>> fourSum (int[] nums , int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; i++) {
//            if (nums[i] > target)
//                return lists;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int goal = target - nums[i];
            for (int j = i + 1 ; j < nums.length ; j++) {
//                if (nums[j] > goal)
//                    break;
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
                        lists.add(Arrays.asList(nums[i] , nums[j] , nums[left] , nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    }
                }
            }
        }
        return lists;
    }

}