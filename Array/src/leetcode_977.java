import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.sort;

/**
 * ClassName: leetcode_977
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/18 20:24
 *
 * @Author lyl
 * @Version 1.0
 */
public class leetcode_977 {
    @Test
    public void test () {
        Solution3 solution3 = new Solution3();
        int[] ints = solution3.sortedSquares(new int[]{- 4 , - 1 , 0 , 3 , 10});
        for (int i : ints) {
            System.out.println(i);
        }
    }
}

class Solution3 {
    public int[] sortedSquares (int[] nums) {
//        for (int i = 0 ; i < nums.length ; i++) {
//            nums[i] = nums[i] * nums[i];
//        }
//        sort(nums);
//        return nums;

        int i = 0;
        while (nums[i] < 0 && i < nums.length) {
            nums[i] = nums[i] * nums[i];
            i++;
        }
        int[] newnums = new int[nums.length];
        int k = 0;
        for (int j = i ; j < nums.length ; ) {
            if (i > 0 && nums[j] * nums[j] > nums[i - 1]) {
                newnums[k] = nums[i - 1];
                i--;
            } else {
                newnums[k] = nums[j] * nums[j];
                j++;
            }
            k++;
        }
        return newnums;
    }
}