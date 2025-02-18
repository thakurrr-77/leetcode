class Solution {
    public int arrangeCoins(int n) {
        int ans=(-1+((int)Math.sqrt(1+(8L*n))))/2;
        return ans;
    }
}