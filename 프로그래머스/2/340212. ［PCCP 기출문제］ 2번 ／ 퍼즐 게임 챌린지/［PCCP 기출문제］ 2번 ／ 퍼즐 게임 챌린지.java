import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        int l = Integer.MAX_VALUE; int r = -1;
        for(int i=0; i<diffs.length; i++){
            l = Math.min(diffs[i],l);
            r = Math.max(diffs[i],r);
        }
        
        while(l<=r){
            int mid = (l+r)/2;
            
            if(solvePuzzle(diffs,times,limit,mid)){
                answer = mid;
                r = mid-1;    
            }
            else{
                l = mid+1;
            }
            
        }
        
        return answer;
    }
    
    boolean solvePuzzle(int[] diffs, int[] times, long limit, int mid){
        int time_prev = 0;
        long totalTime = 0;
        for(int i=0; i<diffs.length; i++){
            int diff = diffs[i];
            int time = times[i];
            if(diff<=mid){
                totalTime+=time;
            }
            else{
                totalTime+=((diff-mid)*(time+time_prev)+time);
            }
            time_prev = time;
        }
        
        if(totalTime<=limit){
            return true;
        }
        return false;
    }
}

// time_cur*(diff-level+time_prev)+time_cur
// limit 안에 해결할 수 있으면 l = mid+1
// 해결 못하면 r = mid-1