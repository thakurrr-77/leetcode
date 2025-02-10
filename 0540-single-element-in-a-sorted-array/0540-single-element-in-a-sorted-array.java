class Solution {
    public int singleNonDuplicate(int[] nums) {
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int mid=s+(e-s)%2;
            if(mid%2!=0) mid--;
            int left=mid>0?nums[mid-1]:-1;
            int right=mid<nums.length-1?nums[mid+1]:-1;

            if(left==nums[mid]) e=mid-1;
            else if(right==nums[mid]) s=mid+1;
            else return nums[mid];
        }

        return -1;
    }
}