import java.util.*;

class Solution {
    int[] dp;
    int max1=0, max2=0;
    public int solution(int sticker[]) {
        int answer = 0;
        dp = new int[sticker.length];
        for(int i=0; i<sticker.length-1; i++){
            dp[i] = Math.max((i-2<0?0:dp[i-2])+sticker[i], i-1<0?0:dp[i-1]);
            max1 = Math.max(max1,dp[i]);
        }
        Arrays.fill(dp,0);
        for(int i=1; i<sticker.length; i++){
            dp[i] = Math.max((i-2<0?0:dp[i-2])+sticker[i], i-1<0?0:dp[i-1]);
            max2 = Math.max(max2,dp[i]);
        }
        
        if(max1==0 || max2==0){
            answer = sticker[0];
        }
        else{
            answer = Math.max(max1,max2);
        }
        return answer;
    }
}