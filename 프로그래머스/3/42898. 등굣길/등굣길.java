import java.util.*;

class Solution {
    int answer = 0;
    boolean[][] puddle;
    int[][] dp; // 이 좌표까지 갔을 때 최단거리 개수
    int div = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        puddle = new boolean[n+1][m+1];
        initPuddle(puddles);
        dp = new int[n+1][m+1];
        
        answer = go(m,n,1,1);
        return answer;
    }
    
    int go(int m, int n, int cy, int cx){
        if(dp[cy][cx]>0){
            return dp[cy][cx];
        }
        
        if(cy==n && cx==m){
            return 1;
        }
        
        if(cy+1<=n && !puddle[cy+1][cx]){
            dp[cy][cx]+=(go(m,n,cy+1,cx)%div);
        }
        if(cx+1<=m && !puddle[cy][cx+1]){
            dp[cy][cx]+=(go(m,n,cy,cx+1)%div);
        }
        return dp[cy][cx]%div;
    }
    
    void initPuddle(int[][] puddles){
        
        for(int i=0; i<puddles.length; i++){
            puddle[puddles[i][1]][puddles[i][0]] = true;
        }
    }
}