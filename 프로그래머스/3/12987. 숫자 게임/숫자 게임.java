import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int bi = 0;
        for(int ai = 0; ai<A.length; ai++){
            for(; bi<B.length; bi++){
                if(A[ai]<B[bi]){
                    answer++;
                    bi++;
                    break;
                }
            }
        }
        return answer;
    }
}