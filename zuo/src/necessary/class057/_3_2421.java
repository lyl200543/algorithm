package necessary.class057;

import java.util.Arrays;

/**
 *ClassName: _3_2421
 *Package: necessary.class057
 *Description:创建于 2025/11/3 20:11
 * https://leetcode.cn/problems/number-of-good-paths/
 * 难！！！
 *@Author lyl
 *@Version 1.0
 */
public class _3_2421 {
}

class Solution3 {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        int ans = n;
        build(n);
        Arrays.sort(edges, (e1, e2) -> Math.max(vals[e1[0]], vals[e1[1]]) - Math.max(vals[e2[0]], vals[e2[1]]));
        for (int[] e : edges) {
            ans += union(e[0], e[1], vals);
        }
        return ans;
    }

    private int[] parent;
    private int[] maxcnt;

    private void build(int n) {
        parent = new int[n];
        maxcnt = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            maxcnt[i] = 1;
        }
    }

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }


    //重点：
    private int union(int a, int b, int[] vals) {
        int path = 0;
        int x = find(a);
        int y = find(b);
        //集合的代表元素同时也是集合最大值的下标
        if (vals[x] < vals[y]) {
            parent[x] = y;
        } else if (vals[x] > vals[y]) {
            parent[y] = x;
        } else {
            path = maxcnt[x] * maxcnt[y];
            parent[x] = y;
            maxcnt[y] += maxcnt[x];
        }
        return path;
    }
}