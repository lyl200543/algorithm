package beginning;

import java.util.Arrays;

/**
 *ClassName: class006_1_FindNumber
 *Package: beginning
 *Description:创建于 2025/7/29 20:39
 *1)在有序数组中确定num存在还是不存在
 *2)在有序数组中找>=num的最左位置
 *3)在有序数组中找 <= num的最右位置
 *4)二分搜索不一定发生在有序数组上(比如寻找峰值问题)
 *@Author lyl
 *@Version 1.0
 */
public class class006_1_FindNumber {
    public static void main (String[] args) {
        int N = 1000;
        int V = 50000;
        int turn = 2000;
        System.out.println("测试开始");
        for (int i = 0 ; i < turn ; i++) {
            int n = (int) (Math.random() * N) + 1;
            int[] arr = new int[n];
            for (int j = 0 ; j < arr.length ; j++) {
                arr[j] = (int) (Math.random() * V);
            }
            Arrays.sort(arr);
            int random = (int) (Math.random() * V);
            if (findNumber(arr , random) != simpleFindNumber(arr , random))
                System.out.println("出错了");
        }
        System.out.println("测试结束");
    }

    public static boolean simpleFindNumber (int[] arr , int num) {
        if (arr == null || arr.length == 0)
            return false;
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] == num)
                return true;
        }
        return false;
    }

    public static boolean findNumber (int[] arr , int num) {
        if (arr == null || arr.length == 0)
            return false;
        int left = 0, right = arr.length - 1, mid = 0;
        while (left <= right) {
            //防止溢出
//            mid = left + (right - left) >> 2;
            mid = (left + right) / 2;
            if (mid < num) {
                left = mid + 1;
            } else if (mid > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
