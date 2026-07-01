import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        for(int i=0; i<targets.length; i++){
            targets[i][0]*=2;
            targets[i][1]*=2;
        }
        
        Arrays.sort(targets,(a,b)->{
            return Integer.compare(a[1],b[1]);
        });
        
        for(int cur=0; cur<targets.length; cur++){
            int curEnd = targets[cur][1];
            for(int next=cur+1; next<targets.length; next++){
                int nextFirst = targets[next][0];
                if(curEnd>nextFirst){
                    cur++;
                }
                else{
                    break;
                }
            }
            answer++;
        }
        
        return answer;
    }
}

// cur[1]보다 작은 next[0]을 모두 찾음. 
// 하나 남았을 때 그냥 제거