import java.util.*;

class Solution {
    class Cord{
        int y;
        int x;
        int d;
        public Cord(int y, int x, int d){
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
    
    int[][] map; // 0은 감, 1은 못감
    int[][] dp;
    int[] dx = {1,0};
    int[] dy = {0,1};
    
    public int solution(int m, int n, int[][] puddles) {
        initMap(m,n,puddles);
        return go(0,0);
    }
    
    int go(int y, int x){
        if(y==map.length-1 && x==map[0].length-1){ // 목적지에 도달 or 최단경로로 갈 수 있음
            return 1;
        }
        
        if(dp[y][x]!=-1){
            return dp[y][x];
        }

        int sum = 0;
        for(int i=0; i<2; i++){
            int ny = y+dy[i]; int nx = x+dx[i];
            if(ny>=map.length ||  nx>=map[0].length || map[ny][nx]==1){
                continue;
            }
            sum = (sum + go(ny,nx))%1000000007;
        }
        
        dp[y][x] = sum;
        return dp[y][x];
    }
    
    void initMap(int m, int n, int[][] puddles){
        map = new int[n][m];
        dp = new int[n][m];
        
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        
        for(int i=0; i<puddles.length; i++){
            int x = puddles[i][0]; int y = puddles[i][1];
            map[y-1][x-1] = 1;
        }
    }
}