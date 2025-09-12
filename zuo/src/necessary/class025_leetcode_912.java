package necessary;

/**
 *ClassName: class025_leetcode_912
 *Package: necessary
 *Description:创建于 2025/9/12 20:12
 *堆排序：
 *@Author lyl
 *@Version 1.0
 */
public class class025_leetcode_912 {
}

class Solution5 {
    public int[] sortArray(int[] nums) {
        if (nums.length == 1)
            return nums;
        //从前往后插入 O(n*logn)
        // heapSort1(nums);
        //从后往前插入 O(n)
        heapSort2(nums);
        return nums;
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    //从下往上
    public static void heapInsert(int[] nums, int i) {
        while (nums[i] > nums[(i - 1) / 2]) {
            swap(nums, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    //从上往下
    public static void heapify(int[] nums, int i, int size) {
        int left = 0, best = 0;
        while ((left = i * 2 + 1) < size) {
            best = left + 1 < size && nums[left + 1] > nums[left] ? left + 1 : left;
            best = nums[i] > nums[best] ? i : best;
            if (best == i) {
                break;
            } else {
                swap(nums, i, best);
                i = best;
            }

        }
    }

    public static void heapSort1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i);
        }
        int size = nums.length;
        while (size > 0) {
            swap(nums, 0, size - 1);
            size--;
            heapify(nums, 0, size);
        }
    }

    public static void heapSort2(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            heapify(nums, i, nums.length);
        }
        int size = nums.length;
        while (size > 0) {
            swap(nums, 0, size - 1);
            size--;
            heapify(nums, 0, size);
        }
    }
}