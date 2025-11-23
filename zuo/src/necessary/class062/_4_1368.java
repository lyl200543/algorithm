package necessary.class062;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *ClassName: _4_1368
 *Package: necessary.class062
 *Description:创建于 2025/11/22 22:43
 *  https://leetcode.cn/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
 *@Author lyl
 *@Version 1.0
 */
public class _4_1368 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.minCost(new int[][]{new int[]{1,1,1,1}, new int[]{2,2,2,2 }, new int[]{1,1,1,1 },new int[]{2,2,2,2}}));
    }
}

class Solution4 {
    public int minCost(int[][] grid) {
        //        int[] move = new int[] { -1, 0, 1, 0, -1 };
        int[][] move = new int[][] { {}, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int n = grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[] { 0, 0 });
        distance[0][0] = 0;
        while (!deque.isEmpty()) {
            int[] cur = deque.removeFirst();
            int x = cur[0];
            int y = cur[1];
            if (x == n - 1 && y == m - 1) {
                return distance[x][y];
            }
            for (int i = 1; i <= 4; i++) {
                //                nx = x + move[i];
                //                ny = y + move[i + 1];
                //                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                //                    if (grid[x][y] == 1) {
                //                        addToDeque(i, grid[x][y]);
                //                    } else if (grid[x][y] == 2) {
                //                        addToDeque(i, grid[x][y]);
                //                    } else if (grid[x][y] == 3) {
                //                        addToDeque(i, grid[x][y]);
                //                    } else {
                //                        addToDeque(i, grid[x][y]);
                //                    }
                //                }
                int weight = grid[x][y] == i ? 0 : 1;
                int nx = x + move[i][0];
                int ny = y + move[i][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && distance[nx][ny] > distance[x][y] + weight) {
                    distance[nx][ny] = distance[x][y] + weight;
                    if (weight == 0) {
                        deque.addFirst(new int[] { nx, ny });
                    } else {
                        deque.addLast(new int[] { nx, ny });
                    }
                }
            }
        }
        return -1;
    }

//    private void addToDeque(int i, int num) {
//        //i和num不匹配
//        if (i == num && distance[nx][ny] > distance[x][y]) {
//            distance[nx][ny] = distance[x][y];
//            deque.addFirst(new int[] { nx, ny });
//        } else if (i != num && distance[nx][ny] > distance[x][y] + 1) {
//            distance[nx][ny] = distance[x][y] + 1;
//            deque.addLast(new int[] { nx, ny });
//        }
//    }
}