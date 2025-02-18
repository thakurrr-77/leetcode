class Solution {
    public long distinctNames(String[] arr) {
        int n=arr.length;
        List<String>[] temp=new ArrayList[26];

        for(int i=0;i<26;i++) temp[i]= new ArrayList<>();

        for(int i=0;i<n;i++){
            char c=arr[i].charAt(0);
            String suff=arr[i].substring(1);
            temp[c-'a'].add(suff);
        }

        long res=0;

        for(int i=0;i<26;i++){
            for(int j=i+1;j<26;j++){
                Set<String> st=new HashSet<>();
                for(String s:temp[i]) st.add(s);
                for(String s:temp[j]) st.add(s);
                int ua=st.size()-temp[j].size();
                int ub=st.size()-temp[i].size();
                res+=2*ua*ub;
            }
        }

        return res;


    }
}