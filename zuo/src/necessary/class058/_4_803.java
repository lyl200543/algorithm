package necessary.class058;

/**
 *ClassName: _4_803
 *Package: necessary.class058
 *Description:创建于 2025/11/6 21:39
 *https://leetcode.cn/problems/bricks-falling-when-hit/
 *技巧：时光倒流
 *1）将要打的砖块的坐标的值-1
 *2）洪水填充将与天花板连接的砖块设为2
 *3）逆序要打的砖块坐标，然后坐标的值+1
 *4）如果坐标在天花板或坐标的上下左右有值为2的砖块，则洪水填充该砖块附近的砖块，设为2，dfs返回数量
 *5）返回答案
 *
 *@Author lyl
 *@Version 1.0
 */
public class _4_803 {
}
class Solution4 {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] ans=new int[hits.length];
        for(int[] h:hits){
            grid[h[0]][h[1]]-=1;
        }
        int label=2;
        for (int i = 0; i < grid[0].length; i++) {
            dfs(grid,0,i,label);
        }
        //时光倒流
        for (int i = hits.length-1; i >=0 ; i--) {
            int x=hits[i][0];
            int y=hits[i][1];
            grid[x][y]+=1;
            if(worth(grid,x,y)){
                ans[i]=dfs(grid,x,y,label)-1;
            }
        }
        return ans;
    }

    private boolean worth(int[][] grid, int x, int y) {
        return grid[x][y]==1 && (x==0 ||
                (x+1<grid.length && grid[x+1][y]==2) ||
                (x-1>=0 && grid[x-1][y]==2) ||
                (y+1<grid[0].length && grid[x][y+1]==2) ||
                (y-1>=0 && grid[x][y-1]==2));

    }

    private int dfs(int[][] grid, int i, int j, int id) {
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j]!=1 )
            return 0;
        grid[i][j]=id;
        return 1+dfs(grid,i+1,j,id)
                +dfs(grid,i-1,j,id)
                +dfs(grid,i,j+1,id)
                +dfs(grid,i,j-1,id);

    }
}











