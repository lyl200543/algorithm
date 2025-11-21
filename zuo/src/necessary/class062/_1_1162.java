package necessary.class062;

/**
 *ClassName: _1_1162
 *Package: necessary.class062
 *Description:创建于 2025/11/19 22:14
 * https://leetcode.cn/problems/as-far-from-land-as-possible/
 * 思路：多源bfs,由陆地出发，每向外扩一层就+1，所有海洋遍历完后，答案为遍历的Level-1
 *@Author lyl
 *@Version 1.0
 */
public class _1_1162 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.maxDistance(new int[][]{new int[]{1, 0, 1}, new int[]{0, 0, 0}, new int[]{1, 0, 1}}));
    }
}

class Solution1 {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] queue = new int[n * n][2];
        int l = 0, r = 0;
        int seas = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue[r][0] = i;
                    queue[r++][1] = j;
                } else {
                    seas++;
                }
            }
        }
        if (seas == 0 || seas == n * n) {
            return -1;
        }
        int level = 0;
        while (l < r) {
            int size = r - l;
            level++;
            for (int k = 0; k < size; k++) {
                int x = queue[l][0];
                int y = queue[l++][1];
                for (int i = 0; i < 4; i++) {
                    int x1 = x + move[i];
                    int y1 = y + move[i + 1];
                    if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < n && grid[x1][y1] == 0) {
                        grid[x1][y1] = level;
                        queue[r][0] = x1;
                        queue[r++][1] = y1;
                    }
                }
            }
        }
        return level - 1;
    }

    //处理上下左右的优化方法：
    private int[] move = new int[]{-1, 0, 1, 0, -1};
}