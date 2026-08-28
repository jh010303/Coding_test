import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        recur(k,0,0,visited,dungeons);
        return answer;
    }
    
    void recur(int k, int cnt, int depth, boolean[] visited, int[][] dungeons){
        answer = Math.max(answer,cnt);
        
        if(depth==dungeons.length){
            return;
        }
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && k>=dungeons[i][0]){
                visited[i] = true;
                recur(k-dungeons[i][1],cnt+1,depth+1, visited,dungeons);
                visited[i] = false;
            }
        }
    }
}

// 각 위치에서 할 수 있는 것
// < 가능할 때 >
// 감. 가지 않음
// < 가능하지 않을 때 >
// 앞으로 불가능하니 가지 않음