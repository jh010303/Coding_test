import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 1000000000000000000L;
        long l = 1; long r = 1000000000000000000L;
        
        while(l<=r){
            long mid = (l+r)/2;
            long people = getPeople(n, times, mid);    
            if(people>=n){
                answer = Math.min(answer,mid);
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return answer;
    }
    
    long getPeople(int n, int[] times, long mid){
        long people = 0;
        for(int i=0; i<times.length; i++){
            long p = mid/times[i];
            people+=p;
        }
        return people;
    }
}