import java.util.*;

class Solution
{
    int[][] dp = new int[1000][1000];
    int[] dx = {1,1,0};
    int[] dy = {0,1,1};
    int answer = -1;
    public int solution(int [][]board)
    {
        for(int i=0; i<1000; i++){
            Arrays.fill(dp[i],-1);
        }
        go(0,0,board, board.length, board[0].length);
        return answer*answer;
    }
    
    int go(int y, int x, int[][] board, int h, int w){
        if(dp[y][x]!=-1){
            return dp[y][x];
        }
        
        int cur = board[y][x]==0?0:1;
        if(y+1>=h || x+1>=w){
            return dp[y][x]=cur;
        }
        
        int next = 1001;
        for(int i=0; i<3; i++){
            next = Math.min(next,go(y+dy[i],x+dx[i],board,h,w));
        }
        if(cur>0){
            cur+=next;
        }
        dp[y][x] = cur;
        answer = Math.max(answer,dp[y][x]);
        return dp[y][x];
    }
}

