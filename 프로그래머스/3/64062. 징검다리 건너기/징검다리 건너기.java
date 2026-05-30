import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int l = Integer.MAX_VALUE; int r = Integer.MIN_VALUE; int mid = 0;
        for(int i=0; i<stones.length; i++){
            int stone = stones[i];
            r = Math.max(r,stone);
            l = Math.min(l,stone);
        }
        
        while(l<=r){
            mid = (l+r)/2;
            int maxL = continueZero(stones, mid);
            
            if(maxL<k){
                answer = Math.max(answer,mid);
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        
        return answer;
    }
    
    int continueZero(int[] stones, int mid){
        int maxCnt = -1;
        int cont = 0;
        for(int i=0; i<stones.length; i++){
            if(stones[i]>=mid){
                cont = 0;
            }
            else{
                cont++;
                maxCnt = Math.max(maxCnt,cont);
            }
        }
        return maxCnt;
    }
}

