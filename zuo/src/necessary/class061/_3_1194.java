package necessary.class061;

import java.io.*;
import java.util.Arrays;

/**
 *ClassName: _3_1194
 *Package: necessary.class061
 *Description:创建于 2025/11/18 21:36
 * https://www.luogu.com.cn/problem/P1194
 *@Author lyl
 *@Version 1.0
 */
public class _3_1194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;
            //边集
            int[][] edges = new int[m * m][3];
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                edges[cnt][0] = 0;
                edges[cnt][1] = i + 1;
                edges[cnt++][2] = n;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= m; j++) {
                    in.nextToken();
                    int w = (int) in.nval;
                    if (w != 0) {
                        edges[cnt][0] = i;
                        edges[cnt][1] = j;
                        edges[cnt++][2] = w;
                    }
                }
            }
            //kruskal:
            build(m);
            int count = 0;
            int len = 0;
            Arrays.sort(edges, (a, b) -> a[2] - b[2]);
            for (int i = 0; i < edges.length; i++) {
                if (union(edges[i][0], edges[i][1])) {
                    count++;
                    len += edges[i][2];
                }
            }
            if (count == m) {
                System.out.println(len);
            } else {
                System.out.println("orz");
            }
        }

    }

    private static int[] parent;

    private static void build(int n) {
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x != y) {
            parent[x] = y;
            return true;
        }
        return false;
    }
}