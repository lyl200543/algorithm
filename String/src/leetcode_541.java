import java.util.Arrays;

/**
 *ClassName: leetcode_541
 *Package: PACKAGE_NAME
 *Description:创建于 2025/5/29 21:14
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_541 {
}

class Solution2 {
    public String reverseStr (String s , int k) {
//        if (k == 1) {
//            return s;
//        }
//        char[] arr = s.toCharArray();
//        int n = arr.length;
//        int index = 0;
//        while (index < n) {
//            if ((index + 1) % k == 0) {
//                int left = index - k + 1;
//                int right = index;
//                while (left < right) {
//                    char tmp = arr[left];
//                    arr[left] = arr[right];
//                    arr[right] = tmp;
//                }
//                if (index + k < n) {
//                    index = index + k;
//                }
//                index++;
//                continue;
//            }
//            if (index == n - 1) {
//                int left = index % (2 * k);
//                int right = index;
//                while (left < right) {
//                    char tmp = arr[left];
//                    arr[left] = arr[right];
//                    arr[right] = tmp;
//                }
//            }
//            index++;
//        }
//        return String.valueOf(arr);


        //改进：
        char[] arr = s.toCharArray();
        for (int i = 0 ; i < s.length() ; i += 2 * k) {
            int left = i;
            int right = i + k - 1 > s.length() - 1 ? s.length() - 1 : i + k - 1;
            while (left < right) {
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }
        return String.valueOf(arr);
    }
}
