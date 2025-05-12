import java.util.HashSet;

/**
 *ClassName: leetcode_1
 *Package: PACKAGE_NAME
 *Description:创建于 2025/5/10 21:41
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_1 {
}

class Solution4 {
    public int[] twoSum (int[] nums , int target) {
        int[] ret = new int[2];
        HashSet<Integer> set = new HashSet<>();
        int i, j, k = 0;
        for (i = 0; i < nums.length ; i++) {
            set.add(nums[i]);
        }
        for (i = 0; i < nums.length ; i++) {
            int num = target - nums[i];
            if (set.contains(num)) {
                for (j = 0; j < nums.length ; j++) {
                    if (num == nums[j]) {
                        ret[k++] = j;
                        nums[j] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        return ret;
    }
}