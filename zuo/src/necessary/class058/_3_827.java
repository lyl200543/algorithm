package necessary.class058;

/**
 *ClassName: _3_827
 *Package: necessary.class058
 *Description:创建于 2025/11/6 20:33
 *https://leetcode.cn/problems/making-a-large-island/
 *思路：1）将不连通的各个1的区域分开（通过改值为2，3 ...），并计算各个区域的大小
 * 2）对剩余 值为0的格子：假设设置该格子为1，分别对上下左右的区域大小相加（注意去重）
 *@Author lyl
 *@Version 1.0
 */
public class _3_827 {
}

class Solution3 {
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int id=2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    dfs(grid,i,j,id++);
                }
            }
        }
        int[] size=new int[id];
        int ans=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]>1){
                    ans=Math.max(ans,++size[grid[i][j]]);
                }
            }
        }
        int up,down,left,right,sum;
        boolean[] visited=new boolean[id];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==0){
                    up=i>0?grid[i-1][j]:0;
                    down=i<n-1?grid[i+1][j]:0;
                    left=j>0?grid[i][j-1]:0;
                    right=j<n-1?grid[i][j+1]:0;
                    visited[up]=true;
                    sum=1+size[up];
                    if(!visited[down]){
                        sum+=size[down];
                        visited[down]=true;
                    }
                    if(!visited[left]){
                        sum+=size[left];
                        visited[left]=true;
                    }
                    if(!visited[right]){
                        sum+=size[right];
                        visited[right]=true;
                    }
                    visited[up]=false;
                    visited[down]=false;
                    visited[left]=false;
                    visited[right]=false;
                    ans=Math.max(ans,sum);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int i, int j, int id) {
        if(i<0 || i>grid.length-1 || j<0 || j>grid.length-1 || grid[i][j]!=1 )
            return;
        grid[i][j]=id;
        dfs(grid,i+1,j,id);
        dfs(grid,i-1,j,id);
        dfs(grid,i,j+1,id);
        dfs(grid,i,j-1,id);
    }
}