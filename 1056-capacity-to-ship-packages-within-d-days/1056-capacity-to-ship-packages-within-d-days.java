class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        int max=0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
            max=Math.max(weights[i],max);
        }

        int s=max;
        int e=sum;

        while(s<e){
            int mid=s+(e-s)/2;
            int count=1;
            int temp=0;
            for(int i=0;i<weights.length;i++){
                if(temp+weights[i]>mid){
                    temp=weights[i];
                    count++;
                }else temp+=weights[i];
            }
            if(count>days) s=mid+1;
            else e=mid;
        }
        return s;
    }
}