package beginning;

import java.util.Arrays;

/**
 *ClassName: class006_2_FindLeft
 *Package: beginning
 *Description:创建于 2025/7/31 21:05
 *2)在有序数组中找>=num的最左位置
 *@Author lyl
 *@Version 1.0
 */
public class class006_2_FindLeft {
    public static void main (String[] args) {
        int N = 100;
        int V = 5000;
        int turn = 1000;
        System.out.println("测试开始");
        for (int i = 0 ; i < turn ; i++) {
            int n = (int) (Math.random() * N) + 1;
            int[] arr = new int[n];
            for (int j = 0 ; j < n ; j++) {
                arr[j] = (int) (Math.random() * V);
            }
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
            int random = (int) (Math.random() * V);
            System.out.println(random);
            if (findMaxLeft(arr , random) != simpleFindMaxLeft(arr , random)) {
                System.out.println(findMaxLeft(arr , random));
                System.out.println(simpleFindMaxLeft(arr , random));
                System.out.println("出错了");
            }
            System.out.println(i);
        }
        System.out.println("测试结束");
    }

    public static int simpleFindMaxLeft (int[] arr , int num) {
        if (arr == null || arr.length == 0)
            return - 1;
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] >= num)
                return i;
        }
        return - 1;
    }

    public static int findMaxLeft (int[] arr , int num) {
        if (arr == null || arr.length == 0)
            return - 1;
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        int answer = - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] >= num) {
                answer = mid;
                right = mid - 1;
            } else if (arr[mid] < num) {
                left = mid + 1;
            }
//            else {
//                answer = mid;
//            }
        }
        return answer;
    }
}
