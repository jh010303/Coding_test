import java.util.*;

class Solution {
    int[][] dp; // [i번 째][b흔적] = a흔적
    public int solution(int[][] info, int n, int m) {
        int answer = 121;
        dp = new int[info.length][121];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],121);
        }
        go(info,n,m,0,0,0);
        
        for(int i=0; i<dp[0].length; i++){
            answer = Math.min(answer,dp[dp.length-1][i]);
        }
        answer = answer==121?-1:answer;
        return answer;
    }
    
    void go(int[][] info, int n, int m, int a, int b, int cnt){
        if(info.length<=cnt){
            return;
        }
        // A가 도둑질
        int newA = a+info[cnt][0];
        if(dp[cnt][b]>newA && newA<n){
            dp[cnt][b]=newA;
            go(info,n,m,newA,b,cnt+1);
        }
        
        // B가 도둑질
        int newB = b+info[cnt][1];
        if(dp[cnt][newB]>a && newB<m){
            dp[cnt][newB] = a;
            go(info,n,m,a,newB,cnt+1);
        }
    }
}