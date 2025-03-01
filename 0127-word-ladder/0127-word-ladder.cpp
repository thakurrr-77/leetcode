class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        set<string> st;

        for(int i=0;i<wordList.size();i++){
            st.insert(wordList[i]);
        }

        queue<pair<string,int>> q;
        
        q.push({beginWord,1});

        while(!q.empty()){
            pair<string,int> node=q.front();
            q.pop();
            string str=node.first;
            if(str==endWord) return node.second;

            for(int i=0;i<str.length();i++){
                for(int j=0;j<26;j++){
                    char ch=(char)(j+'a');
                    char temp=str[i];
                    str[i]=ch;
                    if(st.find(str)!=st.end()){
                        st.erase(str);
                        q.push({str,node.second+1});
                    }
                    str[i]=temp;
                }
            }
        }

        return 0;

    }
};