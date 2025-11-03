package necessary.class057;

import java.util.*;

/**
 *ClassName: _2_2092
 *Package: necessary.class057
 *Description:创建于 2025/11/1 22:25
 *https://leetcode.cn/problems/find-all-people-with-secret/
 *并查集打标签
 *@Author lyl
 *@Version 1.0
 */
public class _2_2092 {
}

class Solution2 {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> ans = new ArrayList<>();
        build(n, firstPerson);
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            int tmp = i;
            union(meetings[i][0], meetings[i][1]);
            while (i + 1 < meetings.length && time == meetings[i + 1][2]) {
                i++;
                union(meetings[i][0], meetings[i][1]);
            }
            i++;

            //超出时间限制：
            //            for (int j = 0; j < n; j++) {
            //                if (!label[find(j)]) {
            //                    parent[j] = j;
            //                }
            //            }

            //有趣：
            for (int j = tmp; j < i; j++) {
                int a = meetings[j][0];
                int b = meetings[j][1];
                if (!label[find(a)]) {
                    parent[a] = a;
                }
                if (!label[find(b)]) {
                    parent[b] = b;
                }
            }

        }
        for (int j = 0; j < n; j++) {
            if (label[find(j)]) {
                ans.add(j);
            }
        }
        return ans;
    }

    private int[] parent;
    private boolean[] label;  //表示集合的代表节点是否在听到秘密的集合内

    private void build(int n, int firstPerson) {
        parent = new int[n];
        label = new boolean[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        parent[firstPerson] = 0;
        label[0] = true;
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
            //重点：
            label[y] |= label[x];
        }
    }
}


//class Solution {
//    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
//        Set<Integer> set = new HashSet<>();
//        set.add(0);
//        set.add(firstPerson);
//        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
//        int i = 0;
//        while (i < meetings.length) {
//            build(n, firstPerson);
//            int time = meetings[i][2];
//            union(meetings[i][0], meetings[i][1]);
//            while (i + 1 < meetings.length && time == meetings[i + 1][2]) {
//                i++;
//                union(meetings[i][0], meetings[i][1]);
//            }
//            i++;
//            for (int j = 1; j < n; j++) {
//                if (set.contains(find(j))) {
//                    set.add(j);
//                }
//            }
//        }
//        return set.stream().toList();
//    }
//
//    private int[] parent;
//
//    private void build(int n, int firstPerson) {
//        parent = new int[n];
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//        }
//        parent[firstPerson] = 0;
//    }
//
//    private int find(int x) {
//        if (parent[x] == x)
//            return x;
//        parent[x] = find(parent[x]);
//        return parent[x];
//    }
//
//    private void union(int a, int b) {
//        int x = find(a);
//        int y = find(b);
//        if (x != y) {
//            parent[y] = x;
//        }
//    }
//}