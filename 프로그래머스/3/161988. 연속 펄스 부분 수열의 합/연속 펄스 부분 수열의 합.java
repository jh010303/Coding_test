import java.util.*;

class Solution {
    long [] sum; // 처음에 1로 시작하는게 기준
    public long solution(int[] sequence) {
        sum = new long[sequence.length+1];
        sum[0] = 0;
        long max = sum[0];
        long min = sum[0];
        for(int i=0; i<sequence.length; i++){
            sum[i+1] = sum[i]+(i%2==0?sequence[i]:sequence[i]*-1);
            max = Math.max(sum[i+1],max);
            min = Math.min(sum[i+1],min);
        }
        
        long answer = max-min;
        return answer;
    }
}

// 연속 펄스 부분 수열 합 공식: sum[e]-sum[s-1]
// 연속 펄스 부분 수열 합 공식: +-(sum[e]-sum[s-1]); => 절댓값이 가장 커야 함