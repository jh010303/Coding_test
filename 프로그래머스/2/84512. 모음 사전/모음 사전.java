class Solution {
    char[] alpha = {'A','E','I','O','U'};
    boolean flag = false;
    int answer = 0;
    public int solution(String word) {
        dfs(0,"",word);
        return answer;
    }
    
    void dfs(int depth, String curWord, String word){
        if(curWord.equals(word)){
            flag = true;
            return;
        }
        
        if(flag || depth>=6){
            return;
        }
        
        answer++;
        for(int i=0; i<5; i++){
            dfs(depth+1,curWord+alpha[i],word);
        }
    }
}