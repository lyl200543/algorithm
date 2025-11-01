package necessary.class057;

import java.util.HashMap;
import java.util.Map;

/**
 *ClassName: _1_947
 *Package: necessary.class057
 *Description:创建于 2025/11/1 22:05
 *https://leetcode.cn/problems/most-stones-removed-with-same-row-or-column/
 *@Author lyl
 *@Version 1.0
 */
public class _1_947 {
}

//通过哈希表将时间复杂度从O(n^2)降到O(n)
class Solution3 {
    Map<Integer, Integer> rowMap = new HashMap<>();
    Map<Integer, Integer> colMap = new HashMap<>();
    private int[] parent;
    private int set;

    public int removeStones(int[][] stones) {
        int n = stones.length;
        build(n);
        for (int i = 0; i < n; i++) {
            //重点
            int x = stones[i][0];
            int y = stones[i][1];
            if (!rowMap.containsKey(x)) {
                rowMap.put(x, i);
            } else {
                union(rowMap.get(x), i);
            }
            if (!colMap.containsKey(y)) {
                colMap.put(y, i);
            } else {
                union(colMap.get(y), i);
            }
        }
        return n - set;
    }

    private void build(int n) {
        rowMap.clear();
        colMap.clear();
        parent = new int[n];
        set = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    private int find(int x) {
        if (parent[x] == x) {
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
            set--;
        }
    }
}


//class Solution1 {
//    private int[] parent;
//    private int set;
//
//    public int removeStones(int[][] stones) {
//        int n = stones.length;
//        build(n);
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
//                    union(i, j);
//                }
//            }
//        }
//        return n - set;
//    }
//
//    private void build(int n) {
//        parent = new int[n];
//        set = n;
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//        }
//    }
//
//    private int find(int x) {
//        if (parent[x] == x) {
//            return x;
//        }
//        parent[x] = find(parent[x]);
//        return parent[x];
//    }
//
//    private void union(int a, int b) {
//        int x = find(a);
//        int y = find(b);
//        if (x != y) {
//            parent[x] = y;
//            set--;
//        }
//    }
//}