class Solution {
    public int splitArray(int[] nums, int k) {
        int start=0;
        int end=0;
        for(int i=0;i<nums.length;i++){
            end+=nums[i];
            start=Math.max(start,nums[i]);
        }

        int ans=Integer.MAX_VALUE;

        while(start<end){
            int mid=start+(end-start)/2;
            
            int count=1;
            int sum=0;
            for(int i=0;i<nums.length;i++){
                if(sum+nums[i]>mid){
                    sum=nums[i];
                    count++;
                }else{
                    sum+=nums[i];
                }
            }
            if(count>k) start=mid+1;
            else end=mid;
        }
        return start;
    }
}