package necessary.class061;

import java.io.*;
import java.util.*;

/**
 *ClassName: _2_prim
 *Package: necessary.class061
 *Description:创建于 2025/11/17 21:23
 *堆提供当前最小的边
 *@Author lyl
 *@Version 1.0
 */
public class _2_prim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;
            ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                in.nextToken();
                int from = (int) in.nval;
                in.nextToken();
                int to = (int) in.nval;
                in.nextToken();
                int weight = (int) in.nval;
                graph.get(from).add(new int[]{to, weight});
                graph.get(to).add(new int[]{from, weight});
            }
            //prim
            Set<Integer> set = new HashSet<>();
            PriorityQueue<int[]> weight = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            int count = 0, len = 0;
            set.add(1);
            for (int[] to : graph.get(1)) {
                weight.add(new int[]{to[0], to[1]});
            }
            while (!weight.isEmpty()) {
                int[] poll = weight.poll();
                int cur = poll[0];
                if (!set.contains(cur)) {
                    set.add(cur);
                    count++;
                    len += poll[1];
                    for (int[] to : graph.get(cur)) {
                        weight.add(new int[]{to[0], to[1]});
                    }
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
}
