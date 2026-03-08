import java.util.*;

class Solution {
    static int[][] dp;
    public int solution(int n, int[][] road, int K) {
        int answer = 1;
        dp = new int[n+1][n+1];
        
        for(int i=1; i<=n; i++){
            Arrays.fill(dp[i],500001);
        }
        for(int i=0; i<road.length; i++){
            int s = road[i][0], e=road[i][1], w = road[i][2];
            dp[s][e] = Math.min(dp[s][e],w);
            dp[e][s] = Math.min(dp[e][s],w);
        }
        
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(i==j || i==k || j==k)continue;
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                }
            }
        }
 
        for(int i=2; i<=n; i++){
            if(dp[1][i]<=K){
                answer++;
            }
        }
        
        return answer;
    }
}