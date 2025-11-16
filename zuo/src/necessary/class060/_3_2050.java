package necessary.class060;

import java.util.ArrayList;

/**
 *ClassName: _3_2050
 *Package: necessary.class060
 *Description:创建于 2025/11/15 22:15
 * https://leetcode.cn/problems/parallel-courses-iii/
 *@Author lyl
 *@Version 1.0
 */
public class _3_2050 {
}

class Solution3 {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : relations) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ans[i + 1] = time[i];
        }
        int[] queue = new int[n];
        int l = 0, r = 0, ret = 0;
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue[r++] = i;
            }
        }
        while (l < r) {
            int cur = queue[l++];
            if (ans[cur] > ret) {
                ret = ans[cur];
            }
            for (int neighbor : graph.get(cur)) {
                if (--inDegree[neighbor] == 0) {
                    queue[r++] = neighbor;
                }
                if (ans[cur] + time[neighbor - 1] > ans[neighbor]) {
                    ans[neighbor] = ans[cur] + time[neighbor - 1];
                }
            }
        }
        return ret;
    }
}