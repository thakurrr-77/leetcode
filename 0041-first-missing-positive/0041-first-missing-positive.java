class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<=0 || nums[i]>nums.length){
                continue;
            }else{
                if(nums[i]==nums[nums[i]-1]) continue;
                if(nums[i]==i+1) continue; 
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
                i--;
            }
        }
        
        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]!=i) return i;
        }
        return nums.length+1;
    }
}