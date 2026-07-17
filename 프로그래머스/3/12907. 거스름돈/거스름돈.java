import java.util.*;

class Solution {
    
    public int solution(int n, int[] money) {
        int div = 1000000007;
        
        // dp[i] : i원을 거슬러 주는 경우의 수
        int[] dp = new int[n + 1];
        
        // 0원을 거슬러 주는 경우는 아무 동전도 사용하지 않는 1가지로 간주
        dp[0] = 1; 
        
        // 바깥쪽 반복문: 동전의 종류
        for(int i = 0; i < money.length; i++){
            int coin = money[i];
            
            // 안쪽 반복문: 목표 금액
            // 동전의 가치(coin)부터 시작해서 n원까지 갱신
            for(int j = coin; j <= n; j++){
                dp[j] += dp[j - coin];
                dp[j] %= div; // 모듈러 연산
            }
        }
        
        return dp[n];
    }
}