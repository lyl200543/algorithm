package necessary.class063;

import java.io.*;
import java.util.Arrays;

/**
 *ClassName: _2_P4799
 *Package: necessary.class063
 *Description:创建于 2025/12/4 20:37
 * https://www.luogu.com.cn/problem/P4799
 *@Author lyl
 *@Version 1.0
 */
public class _2_P4799 {
}

class Main {
    private static int MAXM = 40;
    private static int MAXN = 1 << 20;
    private static long[] arr = new long[MAXM];
    private static long[] lsum = new long[MAXN];
    private static long[] rsum = new long[MAXN];
    private static int n;
    private static long w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            in.nextToken();
            w = (long) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (long) in.nval;
            }
            System.out.println(compute());
        }
        out.flush();
        out.close();
        br.close();
    }

    private static long compute() {
        int lsize = f(0, n >> 1, 0, w, lsum, 0);
        int rsize = f(n >> 1, n, 0, w, rsum, 0);
        Arrays.sort(lsum);
        Arrays.sort(rsum);
        long ans = 0;
        for (int i = 0, j = rsize - 1; i < lsize; ) {
            if (j >= 0 && lsum[i] + rsum[j] <= w) {
                ans += j + 1;
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }

    private static int f(int i, int e, long s, long w, long[] ans, int j) {
        if (s > w) {
            return j;
        }
        if (i == e) {
            ans[j++] = s;
        } else {
            //要i位置上的票
            j = f(i + 1, e, s + arr[i], w, ans, j);
            //不要i位置上的票
            j = f(i + 1, e, s, w, ans, j);
        }
        return j;
    }
}