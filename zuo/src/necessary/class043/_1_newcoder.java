package necessary.class043;

import java.io.*;

/**
 *ClassName: _1_newcoder
 *Package: necessary.class043
 *Description:创建于 2025/11/27 22:27
 *  https://www.nowcoder.com/practice/d88ef50f8dab4850be8cd4b95514bbbd
 *  阶乘模板
 *  n<=10,可以使用全排列
 *@Author lyl
 *@Version 1.0
 */
public class _1_newcoder {
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int count = (int)in.nval;
            for (int i = 0; i < count; i++) {
                in.nextToken();
                int n = (int) in.nval;
                in.nextToken();
                int m = (int)in.nval;
                int[][] arr = new int[n][2];
                for (int j = 0; j < n; j++) {
                    in.nextToken();
                    int hurt = (int)in.nval;
                    in.nextToken();
                    int blood = (int)in.nval;
                    arr[j][0] = hurt;
                    arr[j][1] = blood;
                }
                int ans=minNumber(arr, 0, m);
                ans=ans==Integer.MAX_VALUE?-1:ans;
                System.out.println(ans);
            }
        }
        out.flush();
        br.close();
        out.close();
    }

    //阶乘模板：
    //i:第几个技能
    private static int minNumber(int[][] arr, int i, int m) {
        if (m <= 0) {
            return i;
        }
        if (i == arr.length) {
            return Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;
        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            ans = Math.min(ans, minNumber(arr, i + 1, arr[i][1] < m ? m - arr[i][0] : m - 2 * arr[i][0]));
            swap(arr, i, j);
        }
        return ans;
    }

    private static void swap(int[][] arr, int i, int j) {
        int[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // private static int minNumber(int[][] arr, int m) {
    //     //全排列 n!
    //     int ans = Integer.MAX_VALUE;
    //     for (int i = 0; i < arr.length; i++) {
    //         if (m <= arr[i][1]) {
    //             m -= arr[i][0] * 2;
    //         } else {
    //             m -= arr[i][0];
    //         }
    //         for (int j = 0; j < arr.length; j++) {
    //             if (j != i) {
    //                 if (m <= arr[i][1]) {
    //                     m -= arr[i][0] * 2;
    //                 } else {
    //                     m -= arr[i][0];
    //                 }
    //             }
    //             for (int k = 0; k < arr.length; k++) {
    //                 if (k != i && k != j) {
    //                     if (m <= arr[i][1]) {
    //                         m -= arr[i][0] * 2;
    //                     } else {
    //                         m -= arr[i][0];
    //                     }
    //                 }

    //             }
    //         }
    //     }
    //     return ans;
    // }
}





