class Solution {
public:
    bool canFinish(int N, vector<vector<int>>& prerequisites) {
        vector<vector<int>> adj(N,vector<int>());
        for(int i=0;i<prerequisites.size();i++){
            int u=prerequisites[i][1];
            int v=prerequisites[i][0];
            adj[u].push_back(v);
        }
        
        queue<int> q;
        
        vector<int> indeg(N,0);
        vector<int> topo;
        
        for(int i=0;i<N;i++){
            for(auto it:adj[i]){
                indeg[it]++;
            }
        }
        
        for(int i=0;i<N;i++){
            if(indeg[i]==0) q.push(i);
        }
        
        while(!q.empty()){
            int front=q.front();
            q.pop();
            
            topo.push_back(front);
            
            for(auto it: adj[front]){
                indeg[it]--;
                if(indeg[it]==0) q.push(it);
            }
        }
        
        if(topo.size()==N) return true;
        return false;
        
    }
};