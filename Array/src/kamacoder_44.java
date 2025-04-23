import java.util.Scanner;

import static java.lang.Math.abs;

/**
 * ClassName: kamacoder_44
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/22 20:51
 *
 * @Author lyl
 * @Version 1.0
 */
public class kamacoder_44 {
    public static void main (String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int[][] arr = new int[n][m];
//        int[] area = new int[n + m - 2];
//        int sum = 0;
//        for (int i = 0 ; i < n ; i++) {
//            for (int j = 0 ; j < m ; j++) {
//                arr[i][j] = scanner.nextInt();
//                if (i < n - 1)
//                    area[i] += arr[i][j];
//                if (j < m - 1)
//                    area[n + j - 1] += arr[i][j];
//                sum += arr[i][j];
//            }
//        }
//        for (int i = 1 ; i < n - 1 ; i++) {
//            area[i] += area[i - 1];
//        }
//        for (int i = n ; i < n + m - 2 ; i++) {
//            area[i] += area[i - 1];
//        }
//        int count = n + m - 2;
//        int min = sum;
//        for (int i = 0 ; i < count ; i++) {
//            int diff = abs(area[i] - (sum - area[i]));
//            if (diff < min)
//                min = diff;
//        }
//        scanner.close();
//        System.out.println(min);


        //改进

//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int sum = 0;
//        int[][] vec = new int[n][m];
//        for (int i = 0 ; i < n ; i++) {
//            for (int j = 0 ; j < m ; j++) {
//                vec[i][j] = scanner.nextInt();
//                sum += vec[i][j];
//            }
//        }
//
//        // 统计横向
//        int[] horizontal = new int[n];
//        for (int i = 0 ; i < n ; i++) {
//            for (int j = 0 ; j < m ; j++) {
//                horizontal[i] += vec[i][j];
//            }
//        }
//
//        // 统计纵向
//        int[] vertical = new int[m];
//        for (int j = 0 ; j < m ; j++) {
//            for (int i = 0 ; i < n ; i++) {
//                vertical[j] += vec[i][j];
//            }
//        }
//
//        int result = Integer.MAX_VALUE;
//        int horizontalCut = 0;
//        for (int i = 0 ; i < n ; i++) {
//            horizontalCut += horizontal[i];
//            result = Math.min(result , Math.abs((sum - horizontalCut) - horizontalCut));
//            // 更新result。其中，horizontalCut表示前i行的和，sum - horizontalCut表示剩下的和，作差、取绝对值，得到题目需要的“A和B各自的子区域内的土地总价值之差”。下同。
//        }
//
//        int verticalCut = 0;
//        for (int j = 0 ; j < m ; j++) {
//            verticalCut += vertical[j];
//            result = Math.min(result , Math.abs((sum - verticalCut) - verticalCut));
//        }
//
//        System.out.println(result);
//        scanner.close();
//    }

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int sum = 0;
        int[][] vec = new int[n][m];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                vec[i][j] = scanner.nextInt();
                sum += vec[i][j];
            }
        }

        int result = Integer.MAX_VALUE;
        int count = 0; // 统计遍历过的行

        // 行切分
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                count += vec[i][j];
                // 遍历到行末尾时候开始统计
                if (j == m - 1) {
                    result = Math.min(result , Math.abs(sum - 2 * count));
                }
            }
        }

        count = 0;
        // 列切分
        for (int j = 0 ; j < m ; j++) {
            for (int i = 0 ; i < n ; i++) {
                count += vec[i][j];
                // 遍历到列末尾时候开始统计
                if (i == n - 1) {
                    result = Math.min(result , Math.abs(sum - 2 * count));
                }
            }
        }

        System.out.println(result);
        scanner.close();

    }
}