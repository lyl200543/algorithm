package necessary.class061;

import java.util.Arrays;

/**
 *ClassName: _4_1697
 *Package: necessary.class061
 *Description:创建于 2025/11/18 21:16
 * https://leetcode.cn/problems/checking-existence-of-edge-length-limited-paths/
 *@Author lyl
 *@Version 1.0
 */
public class _4_1697 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        boolean[] ans = solution4.distanceLimitedPathsExist(3, new int[][]{new int[]{0, 1, 2}, new int[]{1, 2, 4}, new int[]{2, 0, 8}, new int[]{1, 0, 16}}, new int[][]{new int[]{0, 1, 2}, new int[]{0, 2, 5}});
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}

class Solution4 {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        int m = queries.length;
        boolean[] ans = new boolean[m];
        int[][] queriesWithIndex = new int[m][4];
        for (int i = 0; i < m; i++) {
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = queries[i][2];
            queriesWithIndex[i][3] = i;
        }
        Arrays.sort(queriesWithIndex, (a, b) -> a[2] - b[2]);
        int cnt = 0;
        build(n);
        for (int i = 0; i < m; i++) {
            while (cnt < edgeList.length && edgeList[cnt][2] < queriesWithIndex[i][2]) {
                union(edgeList[cnt][0], edgeList[cnt][1]);
                cnt++;
            }
            ans[queriesWithIndex[i][3]] = isSameSet(queriesWithIndex[i][0], queriesWithIndex[i][1]);
        }
        return ans;
    }

    private int[] parent;

    private void build(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    private int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x != y) {
            parent[x] = y;
        }
    }

    private boolean isSameSet(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x == y) {
            return true;
        }
        return false;
    }
}