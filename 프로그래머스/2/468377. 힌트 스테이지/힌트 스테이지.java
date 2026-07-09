import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int[] hintList;
    
    public int solution(int[][] cost, int[][] hint) {
        hintList = new int[cost.length];
        backTracking(cost,hint,0,0);
        return answer;
    }
    
    void backTracking(int[][] cost, int[][] hint, int stage, int curCost){
        if(stage==cost.length){
            answer = Math.min(answer,curCost);
            return;
        }
        
        // 힌트권 사용 & 비용 차감
        curCost+=cost[stage][Math.min(hintList[stage],cost.length-1)]; 
        
        // 힌트 구매 X
        backTracking(cost,hint,stage+1,curCost);
        
        // 힌트 구매
        if(stage<hint.length){
            curCost+=hint[stage][0];
            for(int i=1; i<hint[stage].length; i++){
                hintList[hint[stage][i]-1]++;
            }
            
            backTracking(cost,hint,stage+1,curCost);
            
            for(int i=1; i<hint[stage].length; i++){
                hintList[hint[stage][i]-1]--;
            }
        }   
    }
}

// 힌트권 = 스테이지 개수 = n
// 힌트권을 많이 사용할수록 비용 줄어들음
// 하나의 스테이지에서 힌트권 n-1 사용 가능
// 각 스테이지에서 힌트 번들 최대 1개 구매 가능
// 힌트 번들에는 힌트권 k장 들어있음. 같은 번호 중복 가능
// i에서 판매한 힌트 번들에는 항상 i+1 이상의 번호를 가진 힌트권만 있음
// 모든 스테이지를 해결하는데 필요한 최소 비용

// 각 스테이지에서 할 수 있는 행동
// 1. 해당 스테이지에 대한 힌트권이 있다면 힌트 모두 사용 + 비용 차감
// 2. 이번 스테이지에서 힌트 구매 + 비용 차감 or 힌트 구매 X

// 백트래킹 사용 -> 2^16

