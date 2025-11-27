package necessary.class062;

import java.util.PriorityQueue;

/**
 *ClassName: _5_407
 *Package: necessary.class062
 *Description:创建于 2025/11/26 22:25
 * https://leetcode.cn/problems/trapping-rain-water-ii/
 * 二维接雨水
 * bfs与堆结合
 *@Author lyl
 *@Version 1.0
 */
public class _5_407 {
}
class Solution5 {
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    heap.add(new int[] { i, j, heightMap[i][j] });
                    visited[i][j] = true;
                } else {
                    visited[i][j] = false;
                }
            }
        }
        int ans = 0;
        int[] move = new int[] { -1, 0, 1, 0, -1 };
        while (!heap.isEmpty()) {
            int[] record = heap.remove();
            int x = record[0];
            int y = record[1];
            int w = record[2];
            ans += w - heightMap[x][y];
            for (int i = 0; i < 4; i++) {
                int nx = x + move[i];
                int ny = y + move[i + 1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    heap.add(new int[] { nx, ny, Math.max(w, heightMap[nx][ny]) });
                    visited[nx][ny]=true;
                }
            }
        }
        return ans;
    }
}