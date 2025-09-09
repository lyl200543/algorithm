package beginning;

/**
 *ClassName: class021_leetcode_912
 *Package: beginning
 *Description:创建于 2025/9/8 19:05
 *归并排序
 *先把左边排好序，再把右边排好序，最后merge(指针)
 *O(n*logn),减少了比较行为
 *@Author lyl
 *@Version 1.0
 */
public class class021_leetcode_912 {

}

class Solution6 {
    public static int MAXN = 50001;
    public static int[] arr = new int[MAXN];
    public static int[] help = new int[MAXN];

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
        //递归版
        // mergeSort1(0, n - 1);
        //非递归版
        mergeSort2(n);
        for (int i = 0; i < n; i++) {
            nums[i] = arr[i];
        }
        return nums;
    }

    public static void mergeSort1(int l, int r) {
        if (l == r)
            return;
        int m = (l + r) / 2;
        mergeSort1(l, m);
        mergeSort1(m + 1, r);
        mergeArr(l, m, r);
    }

    public static void mergeSort2(int n) {
        for (int l, m, r, step = 1; step < n; step <<= 1) {
            l = 0;
            while (l < n) {
                m = l + step - 1;
                if (m + 1 >= n)
                    break;
                r = Math.min(l + (step << 1) - 1, n - 1);
                mergeArr(l, m, r);
                l = r + 1;
            }
        }

    }

    public static void mergeArr(int l, int m, int r) {
        int i = l;
        int a = l;
        int b = m + 1;
        while (a <= m && b <= r) {
            help[i++] = arr[a] < arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= m) {
            help[i++] = arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        for (int j = l; j <= r; j++) {
            arr[j] = help[j];
        }
    }
}