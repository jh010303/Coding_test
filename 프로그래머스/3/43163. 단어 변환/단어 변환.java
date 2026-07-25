import java.util.*;

class Solution {
    int answer = 51;
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        boolean poss = false;
        for(int i=0; i<words.length; i++){
            if(target.equals(words[i])){
                poss = true;
            }
        }
        
        if(poss){
            dfs(begin,target,0,words,visited);
        }
        
        return answer==51?0:answer;
    }
    
    void dfs(String begin, String target, int depth, String[] words, boolean[] visited){
        if(begin.equals(target)){
            answer = Math.min(depth, answer);
            return;
        }
        
        for(int i=0; i<words.length; i++){
            if(!visited[i] && compareWord(begin,words[i])){
                visited[i] = true;
                dfs(words[i],target,depth+1,words,visited);
                visited[i] = false;
            }
        }
        
    }
    
    boolean compareWord(String s1, String s2){
        int diff = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++;
            }
        }
        if(diff==1){
            return true;
        }
        return false;
    }
}