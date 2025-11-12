package necessary.class059;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *ClassName: _5_936
 *Package: necessary.class059
 *Description:创建于 2025/11/12 20:42
 * https://leetcode.cn/problems/stamping-the-sequence/
 *@Author lyl
 *@Version 1.0
 */
public class _5_936 {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        solution5.movesToStamp("uskh", "uskhkhhskh");
    }
}

class Solution5 {
    public int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        int m = s.length;
        int n = t.length;
        int[] inDegree = new int[n - m + 1];
        Arrays.fill(inDegree, m);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] queue = new int[n - m + 1];
        int l = 0, r = 0;
        for (int i = 0; i < n - m + 1; i++) {
            for (int j = 0; j < m; j++) {
                if (s[j] == t[i + j]) {
                    if (--inDegree[i] == 0) {
                        queue[r++] = i;
                    }
                } else {
                    graph.get(i + j).add(i);
                }
            }
        }
        int[] ans = new int[n - m + 1];
        int size = n - m + 1;
        int[] visited = new int[n];
        while (l < r) {
            int node = queue[l++];
            ans[--size] = node;
            for (int i = 0; i < m; i++) {
                if (visited[node + i] == 0) {
                    for (int k : graph.get(node + i)) {
                        if (--inDegree[k] == 0) {
                            queue[r++] = k;
                        }
                    }
                    visited[node + i] = 1;
                }
            }
        }
        return size == 0 ? ans : new int[0];
    }
}