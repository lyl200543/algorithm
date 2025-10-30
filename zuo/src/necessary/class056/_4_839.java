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
}

class Solution2 {
    private int[] parent;

    public int numSimilarGroups(String[] strs) {
        build(strs.length);
        for (int i = 0; i < strs.length; i++) {
            
        }
    }

    private void build(int length) {
        parent = new int[length];
        for (int i = 0; i < length; i++) {
            parent[i] = i;
        }
    }
}