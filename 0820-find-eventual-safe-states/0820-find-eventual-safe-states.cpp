class Solution {
public:
vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
    int n = graph.size();
    vector<int> topo;
    vector<vector<int>> newAdj(n);
    
    // Reverse the graph
    for (int i = 0; i < n; i++) {
        for (auto it : graph[i]) {
            newAdj[it].push_back(i);
        }
    }
    
    // Compute indegree of reversed graph
    vector<int> indeg(n, 0);
    for (int i = 0; i < n; i++) {
        for (auto it : newAdj[i]) {
            indeg[it]++;
        }
    }
    
    // Queue for topological sorting
    queue<int> q;
    for (int i = 0; i < n; i++) {
        if (indeg[i] == 0) q.push(i);
    }
    
    // Process nodes in topological order
    while (!q.empty()) {
        int front = q.front();
        q.pop();
        topo.push_back(front);
        for (auto it : newAdj[front]) {
            indeg[it]--;
            if (indeg[it] == 0) q.push(it);
        }
    }    

    // Nodes should be returned in sorted order
    sort(topo.begin(), topo.end());
    return topo;
}

};