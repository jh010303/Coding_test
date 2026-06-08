import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long l = 1; long r = 1000000000000000001L;
        long answer = r;
        while(l<=r){
            long mid = (l+r)/2L;
            long cnt = getCnt(mid,n,times);
            
            if(cnt>=n){
                answer = Math.min(answer,mid);
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return answer;
    }
    
    long getCnt(long mid, int n, int[] times){
        long cnt = 0;
        for(int i=0; i<times.length; i++){
            cnt+=(mid/times[i]);
            if(cnt>=n){
                break;
            }
        }
        return cnt;
    }
}