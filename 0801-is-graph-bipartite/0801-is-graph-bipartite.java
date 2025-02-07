class Solution {


    boolean dfs(int src,int col,int[][] graph,int[] color){
        color[src]=col;
        for(int it:graph[src]){
            if(color[it]==-1){
                int newCol=col==1?0:1;
                if(!dfs(it,newCol,graph,color)) return false;
            }else if(color[it]==col) return false;
        }


        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] color=new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                if(!dfs(i,0,graph,color)) return false;
            }
        }
        return true;
    }
}