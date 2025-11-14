package necessary.class060;

import java.io.*;
import java.util.ArrayList;


/**
 *ClassName: _1
 *Package: necessary.class060
 *Description:创建于 2025/11/14 20:43
 * https://www.luogu.com.cn/problem/P4017
 *@Author lyl
 *@Version 1.0
 */
public class _1 {
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        //        while (in.nextToken() != StreamTokenizer.TT_EOF) {
        in.nextToken();
        int n = (int) in.nval;
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        indegree = new int[n + 1];
        in.nextToken();
        int m = (int) in.nval;
        for (int i = 0, u, v; i < m; i++) {
            in.nextToken();
            u = (int) in.nval;
            in.nextToken();
            v = (int) in.nval;
            addEdge(u, v);
            indegree[v]++;
        }
        out.println(ways(n + 1));
        //        }
        out.flush();
        out.close();
        br.close();
    }

    private static ArrayList<ArrayList<Integer>> graph;
    private static int[] indegree;
    private static int MOD = 80112002;

    private static int ways(int n) {
        int[] queue = new int[n];
        int[] lines = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (indegree[i] == 0) {
                queue[r++] = i;
                lines[i] = 1;
            }
        }
        int ans = 0;
        while (l < r) {
            int node = queue[l++];
            if (graph.get(node).isEmpty()) {
                ans = (ans + lines[node]) % MOD;
            }
            else{
                for (int neighbor : graph.get(node)) {
                    if (--indegree[neighbor] == 0) {
                        queue[r++] = neighbor;
                    }
                    lines[neighbor] = (lines[neighbor] + lines[node]) % MOD;
                }
            }
        }
        return ans;
    }

    private static void addEdge(int u, int v) {
        graph.get(u).add(v);
    }
}