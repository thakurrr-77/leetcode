class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int [][] ans=new int[mat.length][mat[0].length];
        int [][] vis=new int[mat.length][mat[0].length];

        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){ 
                    q.add(new int[]{i,j,0});
                    vis[i][j]=1;
                }
            }
        } 

        int[] rows={-1,0,1,0};
        int[] cols={0,-1,0,1};

        while(!q.isEmpty()){
            int[] temp=q.poll();
            int row=temp[0];
            int col=temp[1];
            int steps=temp[2];
            ans[row][col]=steps;
            for(int i=0;i<4;i++){
                int newRow=row+rows[i];
                int newCol=col+cols[i];

                if(newRow>=0 && newRow<mat.length && newCol>=0 && newCol<mat[0].length && vis[newRow][newCol]==0){
                    vis[newRow][newCol]=1;
                    q.add(new int[]{newRow,newCol,steps+1});
                }
            }

        }

        return ans;
    }
}