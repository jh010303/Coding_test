import java.util.*;

class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        for(int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }
        
        while(!pq.isEmpty()){
            int s1 = pq.poll();
            if(pq.isEmpty() && s1<K){
                answer=-1;
                break;
            }
            else if(s1>=K){
                break;
            }
            else{
                int s2 = pq.poll();
                int newS = s1+(s2*2);
                pq.offer(newS);
            }    
            answer++;
        }
        return answer;
    }
}