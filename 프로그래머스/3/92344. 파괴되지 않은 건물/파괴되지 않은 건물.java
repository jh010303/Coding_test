import java.util.*;

class Solution {
    int[][] dp;
    public int solution(int[][] board, int[][] skill) {
        int answer = board.length*board[0].length;
        dp = new int[board.length+1][board[0].length+1];
        
        for(int i=0; i<skill.length; i++){
            int type = skill[i][0], r1 = skill[i][1], c1 = skill[i][2],
            r2 = skill[i][3]+1, c2 = skill[i][4]+1, degree = skill[i][5];     
            dp[r1][c1]+=(type==1?-1*degree:degree);
            dp[r1][c2]+=(type==1?degree:-1*degree);
            dp[r2][c1]+=(type==1?degree:-1*degree);
            dp[r2][c2]+=(type==1?-1*degree:degree);
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j]+=dp[i-1][j];
            }
        }
        
        for(int i=0; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                dp[i][j]+=dp[i][j-1];
            }
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                board[i][j]+=dp[i][j];
                if(board[i][j]<=0){
                    answer--;
                }
            }
        }
        

        return answer;
    }
}
