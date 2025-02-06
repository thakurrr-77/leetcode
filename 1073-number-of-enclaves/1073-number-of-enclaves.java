class Solution {

    void dfs(int i,int j,int[][] board,int[][] vis){
        if(i<0 || i==board.length || j<0 ||j==board[0].length ||vis[i][j]==1) return;
        if(board[i][j]==0) return;
        vis[i][j]=1;
        dfs(i+1,j,board,vis);
        dfs(i,j+1,board,vis);
        dfs(i-1,j,board,vis);
        dfs(i,j-1,board,vis);
    }

    public int numEnclaves(int[][] board) {
        int vis[][]=new int[board.length][board[0].length];

        for(int i=0;i<vis[0].length;i++){
            if(board[0][i]==1) dfs(0,i,board,vis);
        }
        for(int i=1;i<vis.length;i++){
            if(board[i][board[0].length-1]==1) dfs(i,board[0].length-1,board,vis);
        }
        for(int i=1;i<vis[0].length-1;i++){
            if(board[board.length-1][i]==1) dfs(board.length-1,i,board,vis);
        }
        for(int i=1;i<vis.length;i++){
            if(board[i][0]==1) dfs(i,0,board,vis);
        }

        int count=0;
        for(int i=0;i<vis.length;i++){
            for(int j=0;j<vis[0].length;j++){
                if(vis[i][j]==0 && board[i][j]==1) count++;
            }
        }
        return count;
        
    }
}