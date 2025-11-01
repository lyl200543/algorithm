package necessary.class056;

/**
 *ClassName: _5_200
 *Package: necessary.class056
 *Description:创建于 2025/10/31 21:23
 * https://leetcode.cn/problems/number-of-islands/description/
 *@Author lyl
 *@Version 1.0
 */
public class _5_200 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.numIslands(new char[][]{new char[]{'1', '1', '1', '1', '0'}, new char[]{'1', '1', '0', '1', '0'}, new char[]{'1', '1', '0', '0', '0'}, new char[]{'0', '0', '0', '0', '0'}}));


    }
}

class Solution3 {
    private int[] parent;
    private int set;

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        build(row, col, grid);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j + 1 < col && grid[i][j] == '1' && grid[i][j + 1] == '1') {
                    union(i * col + j, i * col + j + 1);
                }
                if (i + 1 < row && grid[i][j] == '1' && grid[i + 1][j] == '1') {
                    union(i * col + j, (i + 1) * col + j);
                }
            }
        }
        return set;
    }

    private void build(int row, int col, char[][] grid) {
        parent = new int[row * col];
        set = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    parent[i * col + j] = i * col + j;
                    set++;
                }
            }
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
            set--;
        }
    }
}