import java.util.*;

class Solution {
    boolean[][] puddleList;
    int[][] dp;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        puddleList = new boolean[n+1][m+1];
        dp = new int[n+1][m+1];
        
        for(int i=0; i<puddles.length; i++){
            puddleList[puddles[i][1]][puddles[i][0]] = true;
        }
        
        return recurSive(1,1,m,n);
    }
    
    int recurSive(int y, int x, int m, int n){
        if(y>n || x>m || puddleList[y][x]){
            return 0;
        }
        
        if(y==n && x==m){
            return 1;
        }
        
        if(dp[y][x]>0){
            return dp[y][x];
        }
        
        dp[y][x] = (recurSive(y+1,x,m,n) + recurSive(y,x+1,m,n))%1000000007;
        return dp[y][x];
    }
}