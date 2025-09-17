package necessary;

import java.util.Arrays;

/**
 *ClassName: class027_3_leetcode_2208
 *Package: necessary
 *Description:创建于 2025/9/16 19:32
 *使用系统给的堆--》如何改进：
 * 自己建堆，插入时自下向上
 * 将所有数字<<20,留出 /2的空间，防止double精度不够
 *@Author lyl
 *@Version 1.0
 */
public class class027_3_leetcode_2208 {
}

class Solution7 {
    public static int MAXN = 100001;
    public static long[] heap = new long[MAXN];
    public static int n;

    public int halveArray (int[] nums) {
        n = nums.length;
        long sum = 0;
        for (int i = n - 1 ; i >= 0 ; i--) {
            heap[i] = (long) nums[i] << 20;
            sum += heap[i];
            heapify(i);
        }
        sum = sum / 2;
        long sub = 0;
        int count = 0;
        while (sub < sum) {
            heap[0] = heap[0] / 2;
            sub += heap[0];
            heapify(0);
            count++;
        }
        return count;
    }

    public static void swap (int a , int b) {
        long tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    public static void heapify (int start) {
        int i = start;
        while (i * 2 + 1 < n) {
            int left = i * 2 + 1;
            int best = left + 1 < n && heap[left + 1] > heap[left] ? left + 1 : left;
            best = heap[i] < heap[best] ? best : i;
            if (i == best) {
                break;
            }
            swap(i , best);
            i = best;
        }
    }
}