import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0,0};
        int s = 0; int e = 0; int sum = sequence[0];
        int cnt = 1000001;
        
        while(e>=s){
            if(sum>k){
                if(s>=sequence.length){
                    break;
                }
                sum-=sequence[s++];
            }
            else if(sum<k){
                e++;
                if(e>=sequence.length){
                    break;
                }
                sum+=sequence[e];
            }
            else{
                if(e-s<cnt){
                    cnt = e-s;
                    answer[0] = s;
                    answer[1] = e;
                }
                e++;
                if(e>=sequence.length){
                    break;
                }
                sum+=sequence[e];
            }
        }
        return answer;
    }
}

// sum > k => s++
// sum < k => e++
// sum = k => 정답 갱신