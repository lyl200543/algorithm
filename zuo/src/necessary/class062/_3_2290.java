package necessary.class062;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *ClassName: _3_2290
 *Package: necessary.class062
 *Description:创建于 2025/11/22 21:04
 * https://leetcode.cn/problems/minimum-obstacle-removal-to-reach-corner/
 * 01bfs，适用于图中所有边的权重只有0和1两种值，求源点到目标点的最短距离
 * 时间复杂度为0（节点数量+边的数量），为什么不能用传统bfs？
 * 过程：
 * 1，distance[i]表示从源点到i点的最短距离，初始时所有点的distance设置为无穷大
 * 2，源点进入双端队列，distance[源点]=0
 * 3，双端队列头部弹出x，
 * A，如果x是目标点，返回distance[x]表示源点到目标点的最短距离
 * B，考察从x出发的每一条边，假设某边去y点，边权为w
 * 1)如果rdistance[y]>distance[x]+w，处理该边；否则忽略该边
 * 2)处理时，更新distance[y]=distance[x]+ W
 * 如果w==0，y从头部进入双端队列。继续重复步骤3
 * 如果w==1，y从尾部进入双端队列。继续重复步骤3
 * 4，双端队列为空停止
 * 正确性证明以及为什么不需要visited来标记节点
 *@Author lyl
 *@Version 1.0
 */
public class _3_2290 {
}

class Solution3 {
    public int minimumObstacles(int[][] grid) {
        int[] move = new int[] { -1, 0, 1, 0, -1 };
        int n = grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[0][0] = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[] { 0, 0 });
        while (!deque.isEmpty()) {
            int[] cur = deque.removeFirst();
            int x = cur[0];
            int y = cur[1];
            if (x == n - 1 && y == m - 1) {
                return distance[x][y];
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + move[i];
                int ny = y + move[i + 1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && distance[nx][ny] > distance[x][y] + grid[nx][ny]) {
                    distance[nx][ny] = distance[x][y] + grid[nx][ny];
                    if (grid[nx][ny] == 0) {
                        deque.addFirst(new int[] { nx, ny });
                    } else {
                        deque.addLast(new int[] { nx, ny });
                    }
                }
            }
        }
        return -1;
    }
}