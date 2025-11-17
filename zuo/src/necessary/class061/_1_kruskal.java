package necessary.class061;

import java.io.*;
import java.util.Arrays;

/**
 *ClassName: _1_kruskal
 *Package: necessary.class061
 *Description:创建于 2025/11/17 21:20
 *https://www.luogu.com.cn/problem/P3366
 *常用
 *边按权值排好序，并查集判断是否形成环
 *遍历边集，不形成环就加入最小生成树（无向有权图）中
 *@Author lyl
 *@Version 1.0
 */
public class _1_kruskal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;
            build(n);
            int[][] edges = new int[m][3];
            for (int i = 0; i < m; i++) {
                in.nextToken();
                edges[i][0] = (int) in.nval;
                in.nextToken();
                edges[i][1] = (int) in.nval;
                in.nextToken();
                edges[i][2] = (int) in.nval;
            }
            Arrays.sort(edges, (a, b) -> a[2] - b[2]);
            int len = 0;
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (union(edges[i][0], edges[i][1])) {
                    len += edges[i][2];
                    count++;
                }
            }
            if (count == n - 1) {
                System.out.println(len);
            } else {
                System.out.println("orz");
            }
        }
        out.flush();
        out.close();
        br.close();
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


