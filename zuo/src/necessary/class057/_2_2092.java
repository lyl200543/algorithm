package necessary.class057;

import java.util.*;

/**
 *ClassName: _2_2092
 *Package: necessary.class057
 *Description:创建于 2025/11/1 22:25
 *https://leetcode.cn/problems/find-all-people-with-secret/
 *@Author lyl
 *@Version 1.0
 */
public class _2_2092 {
}

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(firstPerson);
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        int i = 0;
        while (i < meetings.length) {
            build(n, firstPerson);
            int time = meetings[i][2];
            union(meetings[i][0], meetings[i][1]);
            while (i + 1 < meetings.length && time == meetings[i + 1][2]) {
                i++;
                union(meetings[i][0], meetings[i][1]);
            }
            i++;
            for (int j = 1; j < n; j++) {
                if (set.contains(find(j))) {
                    set.add(j);
                }
            }
        }
        return set.stream().toList();
    }

    private int[] parent;

    private void build(int n, int firstPerson) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        parent[firstPerson] = 0;
    }

    private int find(int x) {
        if (parent[x] == x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x != y) {
            parent[y] = x;
        }
    }
}