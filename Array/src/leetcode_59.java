/**
 * ClassName: leetcode_59
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/20 20:10
 *
 * @Author lyl
 * @Version 1.0
 */
public class leetcode_59 {
}

class Solution5 {
    public int[][] generateMatrix (int n) {
        //左闭右闭
//        int[][] arr = new int[n][n];
//        int row = 0;
//        int column = 0;
//        int count = 0;
//        for (int i = 1 ; i <= n * n ; ) {
//            while (column < n - count) {
//                if (arr[row][column] == 0) {
//                    arr[row][column] = i;
//                    i++;
//                }
//                column++;
//            }
//            column--;
//            while (row < n - count) {
//                if (arr[row][column] == 0) {
//                    arr[row][column] = i;
//                    i++;
//                }
//                row++;
//            }
//            row--;
//            while (column >= 0 + count) {
//                if (arr[row][column] == 0) {
//                    arr[row][column] = i;
//                    i++;
//                }
//                column--;
//            }
//            column++;
//            while (row >= 1 + count) {
//                if (arr[row][column] == 0) {
//                    arr[row][column] = i;
//                    i++;
//                }
//                row--;
//            }
//            row++;
//            count++;
//        }
//        return arr;


        //左闭右开：解决了数组越界的问题
        int[][] arr = new int[n][n];
        int startx = 0;
        int starty = 0;
        int i, j;
        int offset = 1;
        int count = 1;
        int loop = 1;
        //以一圈作为一个循环，奇数单独处理
        //转一圈正方形的边长-2，故 loop= n/2
        while (loop <= n / 2) {
            //顶部
            for (j = starty; j < n - offset ; j++) {
                arr[startx][j] = count++;
            }
            //右边
            for (i = startx; i < n - offset ; i++) {
                arr[i][j] = count++;
            }
            //左边
            for ( ; j > starty ; j--) {
                arr[i][j] = count++;
            }

            //底部
            for ( ; i > startx ; i--) {
                arr[i][j] = count++;
            }
            startx++;
            starty++;
            offset++;
            loop++;
        }
        if (n % 2 == 1) {
            arr[startx][starty] = count;
        }
        return arr;
    }
}