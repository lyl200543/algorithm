import java.util.Scanner;

/**
 * ClassName: kamacoder_58
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/20 21:23
 *
 * @Author lyl
 * @Version 1.0
 */
public class kamacoder_58 {
    public static void main (String[] args) {
        //运行超时，O(n*m),m为查询的次数

//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0 ; i < n ; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        while (scanner.hasNext()) {
//            int left = scanner.nextInt();
//            int right = scanner.nextInt();
//            int sum = 0;
//            for (int i = left ; i <= right ; i++) {
//                sum += arr[i];
//            }
//            System.out.println(sum);
//        }
//        scanner.close();

        //使用前缀和
        //前缀和的思想是重复利用计算过的子数组之和，从而降低区间查询需要累加计算的次数
        //前缀和 在涉及计算区间和的问题时非常有用！

        //例如，我们要统计 vec[i] 这个数组上的区间和。
        //我们先做累加，即 p[i] 表示 下标 0 到 i 的 vec[i] 累加 之和。
        //如果，我们想统计，在vec数组上 下标 2 到下标 5 之间的累加和，那是不是就用 p[5] - p[1] 就可以了

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0 ; i < n ; i++) {
            sum += scanner.nextInt();
            arr[i] = sum;
        }
        while (scanner.hasNext()) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            if (left == 0)
                System.out.println(arr[right]);
            else
                System.out.println(arr[right] - arr[left - 1]);
        }
        scanner.close();
    }

}