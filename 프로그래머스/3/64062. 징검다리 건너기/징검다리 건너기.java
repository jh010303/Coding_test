import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int l = 1; int r = 200000000;
        
        while(l<=r){
            int mid = (l+r)/2;
            
            if(checkM(stones,k,mid)){
                answer = Math.max(answer,mid);
                l = mid+1;
            }
            else{
                r = mid-1;
            }
            
        }
        return answer;
    }
    
    boolean checkM(int[] stones, int k, int mid){
        int contin = 0;
        for(int i=0; i<stones.length; i++){
            if(stones[i]-mid<0){
                contin++;
            }
            else{
                contin = 0;
            }
 
            if(contin>=k){
                return false;
            }
        }
        return true;
    }
}

// 0 1 2 0 0 0 1 0 2 0
// stones 원소에서 result만큼 빼고 연속적 음수의 개수가 k미만이면 정답 갱신하고
// l = mid+1
// 음수의 연속적인 개수가 k이상이면 r = mid-1
