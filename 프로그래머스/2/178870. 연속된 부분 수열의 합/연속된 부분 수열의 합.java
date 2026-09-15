import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int p1=0; int p2=0; int sum = 0; int minWindowSize = sequence.length+1;
        int windowSize = p2-p1+1;
        for(int i=p1; i<=p2; i++){
            sum+=sequence[i];
        }

        while(windowSize>0){
            if(sum > k){
                sum-=sequence[p1++];
            }
            else if(sum < k){
                p2++;
                if(p2>=sequence.length){
                    break;
                }
                sum+=sequence[p2];
            }
            else{
                if(windowSize<minWindowSize){
                    minWindowSize = windowSize;
                    answer[0] = p1; answer[1] = p2;
                }
                p2++;
                if(p2>=sequence.length){
                    break;
                }
                sum+=sequence[p2];
            }
            
            windowSize = p2-p1+1;
        }
        return answer;
    }
}

// 윈도우 합 > k => 윈도우 크기를 줄여야 함
// 윈도우 합 < k => 윈도우 크기를 늘려야 함
// 윈도우 합 == k => 정답 갱신 후 윈도우 크기 늘리기

// 종료 조건 윈도우 크기가 0이 되면 끝