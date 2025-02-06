class Solution {
    public int findMinMoves(int[] machines) {
        int clothes=0;
        for(int i=0;i<machines.length;i++){
            clothes+=machines[i];
        }

        if(clothes%machines.length!=0) return -1;
        int avg=clothes/machines.length;

        int count=0;
        int curr=0;
        int diff=0;
        for(int i=0;i<machines.length;i++){
            diff=machines[i]-avg;
            curr+=diff;
            count=Math.max(count,Math.max(diff,Math.abs(curr)));
        }

        return count;
    }
}