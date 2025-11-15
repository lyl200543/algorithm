package necessary.class060;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *ClassName: _2_851
 *Package: necessary.class060
 *Description:创建于 2025/11/15 20:28
 * https://leetcode.cn/problems/loud-and-rich/
 *@Author lyl
 *@Version 1.0
 */
public class _2_851 {
}

class Solution2 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] ans = new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            ans[i] = i;
        }
        int[] inDegree = new int[n];
        for (int i = 0; i < richer.length; i++) {
            graph.get(richer[i][0]).add(richer[i][1]);
            inDegree[richer[i][1]]++;
        }
        int[] queue = new int[n];
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue[r++] = i;
                ans[i] = i;
            }
        }
        while (l < r) {
            int node = queue[l++];
            for (int neighbor : graph.get(node)) {
                if (--inDegree[neighbor] == 0) {
                    queue[r++] = neighbor;
                }
                ans[neighbor] = quiet[ans[neighbor]] < quiet[ans[node]] ? ans[neighbor] : ans[node];
            }
        }
        return ans;
    }
}