package necessary.class056;


/**
 *ClassName: _3_765
 *Package: necessary.class056
 *Description:创建于 2025/10/30 20:33
 * https://leetcode.cn/problems/couples-holding-hands/
 * 1)首先：将情侣看成一个整体（集合），通过人的ID（0，1，...） -> ID/2 ,情侣在同一个集合内
 * 2)遍历数组，每两个为一组，若两人属于不同集合，则将集合合并
 * 3)重要：元素个数为k的集合 需要k-1次操作将集合内的情侣配对
 * 4)操作数=情侣对数-集合数
 *@Author lyl
 *@Version 1.0
 */
public class _3_765 {
}

class Solution1 {
    private int COUPLE = 31;
    private int[] parent = new int[COUPLE];

    public int minSwapsCouples(int[] row) {
        initalize(row.length / 2);
        int count = row.length / 2;
        for (int i = 0; i < row.length; i += 2) {
            int set1 = row[i] / 2;
            int set2 = row[i + 1] / 2;
            if (!isSameSet(set1, set2)) {
                union(set1, set2);
                count--;
            }
        }
        return row.length / 2 - count;
    }

    private void initalize(int n) {
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

    private boolean isSameSet(int a, int b) {
        return find(a) == find(b);
    }

    private void union(int a, int b) {
        int set1 = find(a);
        int set2 = find(b);
        if (set1 != set2) {
            parent[set1] = set2;
        }
    }
}