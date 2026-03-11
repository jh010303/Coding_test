import java.util.*;
import java.io.*;

class Solution {
    static PriorityQueue<Integer> que = new PriorityQueue<>((a,b)->(b-a));
    
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        for(int i=0; i<enemy.length; i++){
            n-=enemy[i];
            que.offer(enemy[i]);
            if(n<0 && k>0){
                while(k>0 && !que.isEmpty() && n<0){
                    n+=que.poll();
                    k--;
                }
            }
            if(n<0){
                break;
            }
            answer++;
        }
        return answer;
    }
}