import java.util.*;

class Solution {
    int[] hintList = new int[17];
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] cost, int[][] hint) {    
        recurSive(0, 0, cost, hint);
        return answer;
    }
    
    void recurSive(int curCost, int stage, int[][] cost, int[][] hint){
        if(stage>=cost.length){
            answer = Math.min(answer,curCost);
            return;
        }
        
        curCost+=cost[stage][hintList[stage]>=cost[0].length?cost[0].length-1:hintList[stage]];
        recurSive(curCost,stage+1,cost,hint);
        
        if(stage<cost.length-1){
            curCost+=hint[stage][0];
            for(int i=1; i<hint[stage].length; i++){
                hintList[hint[stage][i]-1]++;
            } 
            recurSive(curCost,stage+1,cost,hint);
            for(int i=1; i<hint[stage].length; i++){
                hintList[hint[stage][i]-1]--;
            }
        }
    }
}

// 각 스테이지에서 힌트권이 존재한다면 무조건 사용
// 각 스테이지가 끝나고 힌트를 사거나 사지 않음 -> 백트래킹
// 스테이지 최대 16까지 있음
