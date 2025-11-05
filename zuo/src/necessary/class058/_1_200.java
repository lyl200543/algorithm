package necessary.class058;

/**
 *ClassName: _1_200
 *Package: necessary.class058
 *Description:创建于 2025/11/5 20:56
 *https://leetcode.cn/problems/number-of-islands/description/
 *洪水填充
 *洪水填充是一种很简单的技巧，设置路径信息进行剪枝和统计，类似感染的过程
 *路径信息不撤销，来保证每一片的感染过程可以得到区分
 *看似是暴力递归过程，其实时间复杂度非常好，遍历次数和样本数量的规模一致
 *@Author lyl
 *@Version 1.0
 */
public class _1_200 {
}
class Solution1 {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] != '1')
            return;
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

    }
}