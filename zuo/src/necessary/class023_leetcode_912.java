package necessary;

/**
 *ClassName: class023_leetcode_912
 *Package: beginning
 *Description:创建于 2025/9/10 19:29
 *快速排序：
 *@Author lyl
 *@Version 1.0
 */
public class class023_leetcode_912 {
}

class Solution3 {
    public int[] sortArray (int[] nums) {
        // quickSort1(nums, 0, nums.length - 1);
        quickSort2(nums , 0 , nums.length - 1);
        return nums;
    }

    //经典版本：
//    public static void quickSort1 (int[] nums , int l , int r) {
//        if (l >= r) {
//            return;
//        }
//        int x = nums[l + (int) (Math.random() * (r - l + 1))];
//        int m = partition1(nums , l , r , x);
//        quickSort1(nums , l , m - 1);
//        quickSort1(nums , m + 1 , r);
//    }
//
//    //改进版本：一次性解决相同的x
//    public static int partition1 (int[] nums , int l , int r , int x) {
//        //a表示<=x的越界区域
//        int a = l;
//        int xi = 0;
//        for (int i = l ; i <= r ; i++) {
//            if (nums[i] <= x) {
//                swap(nums , a , i);
//                if (nums[a] == x) {
//                    xi = a;
//                }
//                a++;
//            }
//        }
//        swap(nums , xi , a - 1);
//        return a - 1;
//    }

    public static void quickSort2 (int[] nums , int l , int r) {
        if (l >= r) {
            return;
        }
        //随机行为的时间复杂度为其期望，固定流程的时间复杂度为其最糟情况
        //当x在左右两侧时，情况最糟，为O(n^2)
        //当x在中间时，情况最好，为O(n*logn)
        //随机行为的期望经计算为O(n*logn)
        int x = nums[l + (int) (Math.random() * (r - l + 1))];
        partition2(nums , l , r , x);
        //如果直接使用first,last,可能会在递归中变换
        int left = first;
        int right = last;
        quickSort2(nums , l , left - 1);
        quickSort2(nums , right + 1 , r);
    }


    public static int first;
    public static int last;

    public static void partition2 (int[] nums , int l , int r , int x) {
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (nums[i] < x) {
                swap(nums , first++ , i++);
            } else if (nums[i] > x) {
                swap(nums , last-- , i);
            } else {
                i++;
            }
        }
    }

    public static void swap (int[] nums , int a , int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
