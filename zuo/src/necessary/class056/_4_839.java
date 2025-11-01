package necessary.class056;

/**
 *ClassName: _4_839
 *Package: necessary.class056
 *Description:创建于 2025/10/30 21:42
 * https://leetcode.cn/problems/similar-string-groups/
 *@Author lyl
 *@Version 1.0
 */
public class _4_839 {
    public static void main(String[] args) {
//        Solution2 solution2 = new Solution2();
//        System.out.println(solution2.numSimilarGroups(new String[]{"blw", "bwl", "wlb"}));
    }
}


class Solution2 {
    private int[] parent;
    private int setNum;

    public int numSimilarGroups(String[] strs) {
        build(strs.length);
        int size = strs[0].length();
        setNum = strs.length;
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (find(i) != find(j)) {
                    int count = 0;
                    //提高效率：count>2后没必要再遍历
                    for (int k = 0; k < size && count <= 2; k++) {
                        if (strs[i].charAt(k) != strs[j].charAt(k)) {
                            count++;
                        }
                    }
                    if (count <= 2) {
                        union(i, j);
                    }
                }
            }
        }
        return setNum;
    }

    private void build(int length) {
        parent = new int[length];
        for (int i = 0; i < length; i++) {
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
        int i = find(a);
        int j = find(b);
        if (i != j) {
            parent[i] = j;
            setNum--;
        }
    }
}