package necessary;

import java.util.Arrays;

/**
 *ClassName: class028_leetcode_912
 *Package: necessary
 *Description:创建于 2025/9/18 18:50
 *基数排序：不基于比较的排序算法，O(n)
 *但对排序的数字有要求，只能是数字
 *思路：将数字按位数（个位，十位 ...）依次进桶（0，1，2 ...）
 *然后按桶大小的顺序将数字刷回数组，就完成了一次位数排序（例如一次排完后个位就有序了）
 *桶的思路：0:2    1:3     2:2  ...
 *则    >=0:2   >=1:5    >=2:7
 *将数组从后往前遍历，arr[i]=0,就把arr[i]放到辅助数组help[1]上，然后>=0:2-1=1
 *遍历完arr数组后将help数组的数刷回arr中
 *@Author lyl
 *@Version 1.0
 */
public class class028_leetcode_912 {
}

class Solution8 {
    public static int BASE = 10;
    public static int[] bucket = new int[BASE];
    public static int MAXN = 50001;
    public static int[] help = new int[MAXN];

    public int[] sortArray(int[] nums) {
        //处理负数情况
        int n = nums.length;
        int min = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < min)
                min = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] -= min;
        }
        //找最大位数
        int max=0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max)
                max = nums[i];
        }
        int bits = 0;
        while (max != 0) {
            max = max / BASE;
            bits++;
        }

        //核心代码
        radixSort(nums,bits);

        //处理负数情况
        for (int i = 0; i < n; i++) {
            nums[i] += min;
        }
        return nums;
    }

    public static void radixSort(int[] nums,int bits){
        int n=nums.length;
        int offset = 1;
        for (int i = 0; i < bits; i++) {
            Arrays.fill(bucket, 0);
            for (int j = 0; j < n; j++) {
                int num = (nums[j] / offset) % BASE;
                bucket[num]++;
            }
            for (int j = 1; j < BASE; j++) {
                bucket[j] += bucket[j - 1];
            }
            for (int j = n - 1; j >= 0; j--) {
                int num = (nums[j] / offset) % BASE;
                help[--bucket[num]] = nums[j];
            }
            for (int j = 0; j < n; j++) {
                nums[j] = help[j];
            }
            offset *= BASE;
        }
    }
}