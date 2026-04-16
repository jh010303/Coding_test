import java.util.*;

class Solution {
    boolean[] visited;
    int answer = 51;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        backTracking(begin,target,words,0);
        return answer==51?0:answer;
    }
    
    void backTracking(String begin, String target, String[] words, int depth){
        if(begin.equals(target)){
            answer = Math.min(answer,depth);
        }
        
        for(int i=0; i<words.length; i++){
            if(stringDiffer(words[i],begin)==1 && !visited[i]){
                visited[i] = true;
                backTracking(words[i],target,words,depth+1);
                visited[i] = false;
            }
        }
    }
    
    int stringDiffer(String a, String b){
        int diff = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)){
                diff++;
            }
        }
        return diff;
    }
}