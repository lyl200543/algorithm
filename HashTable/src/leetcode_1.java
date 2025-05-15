import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 *ClassName: leetcode_1
 *Package: PACKAGE_NAME
 *Description:创建于 2025/5/10 21:41
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_1 {
    @Test
    public void test () {
        Solution4 solution4 = new Solution4();
        int[] arr = solution4.twoSum(new int[]{3 , 2 , 4} , 6);
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
}

class Solution4 {
    public int[] twoSum (int[] nums , int target) {
        //虽然往哈希表上靠了，但事件复杂度O(n~2)

//        int[] ret = new int[2];
//        HashSet<Integer> set = new HashSet<>();
//        int i, j;
//        for (i = 0; i < nums.length ; i++) {
//            set.add(nums[i]);
//        }
//
//        for (i = 0; i < nums.length ; i++) {
//            int num = target - nums[i];
//            if (set.contains(num)) {
//                for (j = i + 1; j < nums.length ; j++) {
//                    if (num == nums[j]) {
//                        ret[0] = i;
//                        ret[1] = j;
//                        return ret;
//                    }
//                }
//            }
//        }
//        return ret;


        //使用hashMap,O(n)
        //因为比较的是元素，但返回的是下标，既要存元素又要村、存下标，所以使用hashMap
        //是遍历一遍数组，将遍历过的元素放入hashmap中
        //遍历数组的同时在hashMap中查找是否有相加为目标数的元素

        int[] ret = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                ret[0] = i;
                ret[1] = map.get(tmp);
                return ret;
            }
            map.put(nums[i] , i);
        }
        return ret;

        //注意：map必须存放遍历过的元素，而不能一开始就将所有元素放入map中
        //存放遍历过的元素可以确保数组遍历的当前元素不在map中，方式6=3+3这种情况

    }
}