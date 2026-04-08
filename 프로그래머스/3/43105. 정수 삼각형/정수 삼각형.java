import java.util.*;

class Solution {
    static int[][] dp = new int[500][500];
    public int solution(int[][] triangle) {
        for(int i=0; i<500; i++){
            Arrays.fill(dp[i],-1);
        }
        return go(0,0,triangle);
    }
    
    static int go(int h, int cur, int[][] triangle){
        if(h>=triangle.length){
            return 0;
        }
        if(dp[h][cur]!=-1){
            return dp[h][cur];
        }
        
        dp[h][cur] = Math.max(dp[h][cur],go(h+1,cur,triangle));
        dp[h][cur] = Math.max(dp[h][cur],go(h+1,cur+1,triangle));
        dp[h][cur]+=triangle[h][cur];
        
        return dp[h][cur];
    }    
    
}