package beginning;

import java.util.Arrays;

/**
 *ClassName: beginning.class004
 *Package: PACKAGE_NAME
 *Description:创建于 2025/7/24 21:26
 *选择排序，冒泡排序，插入排序
 *@Author lyl
 *@Version 1.0
 */
public class class004_SelectBubbleInsert {
    public static void main (String[] args) {
        class004_SelectBubbleInsert class004 = new class004_SelectBubbleInsert();
        int[] arr = new int[]{2 , 4 , 3 , 1 , 5};
//        beginning.class004.choice(arr);
//        beginning.class004.bubble(arr);
        class004.insert(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void swap (int[] arr , int x , int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public void choice (int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        int n = arr.length;
        int min;
        for (int i = 0 ; i < n - 1 ; i++) {
            min = i;
            for (int j = i + 1 ; j < n ; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            swap(arr , i , min);
        }
    }

    public void bubble (int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        int n = arr.length;
        for (int i = n - 1 ; i > 0 ; i--) {
            for (int j = 0 ; j < i ; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr , j , j + 1);
            }

        }
    }

    public void insert (int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        int n = arr.length;
        for (int i = 1 ; i < n ; i++) {
            for (int j = i - 1 ; j >= 0 && arr[j] > arr[j + 1] ; j--) {
                swap(arr , j , j + 1);
            }
        }
    }
}
