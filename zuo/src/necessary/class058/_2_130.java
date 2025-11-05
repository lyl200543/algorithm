package necessary.class058;

import java.util.Arrays;

/**
 *ClassName: _2_130
 *Package: necessary.class058
 *Description:创建于 2025/11/5 21:2
 * https://leetcode.cn/problems/surrounded-regions/
 *@Author lyl
 *@Version 1.0
 */
public class _2_130 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solve(new char[][]{new char[]{'X','X','X','X'},new char[]{'X','O','O','X'},new char[]{'X','X','O','X'},new char[]{'X','O','X','X'}});
    }
}
class Solution2 {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        for (int i = 0; i < n; i++) {
            if(board[i][0]=='O'){
                dfs(board,i,0);
            }
            if(board[i][m-1]=='O'){
                dfs(board,i,m-1);
            }
        }
        for (int i = 1; i < m-1; i++) {
            if(board[0][i]=='O'){
                dfs(board,0,i);
            }
            if(board[n-1][i]=='O'){
                dfs(board,n-1,i);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='F')
                    board[i][j]='O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if(i<0 || i> board.length-1 || j<0 || j> board[0].length-1 || board[i][j]!='O')
            return;
        board[i][j]='F';
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }

}