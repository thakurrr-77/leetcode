class Solution {
public:

    int solve(int i,int buy,int cap,vector<int> &prices,vector<vector<vector<int>>> &dp){
        if(cap==-1) return 0;
        if(i==prices.size()) return 0;
        if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];

        int profit=0;

        if(buy==1){
            profit=max(-prices[i]+solve(i+1,0,cap,prices,dp),solve(i+1,1,cap,prices,dp));
        }else{
            profit=max(prices[i]+solve(i+1,1,cap-1,prices,dp),solve(i+1,0,cap,prices,dp));
        }

        return dp[i][buy][cap]=profit;

    }

    int maxProfit(vector<int>& prices) {
        vector<vector<vector<int>>> dp(prices.size(),vector<vector<int>>(2,vector<int>(2,-1))); 
        return solve(0,1,1,prices,dp);
    }
};