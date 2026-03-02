import java.util.*;

class Solution {
    static List<Integer> sumList = new ArrayList<>();
    static int size;
    public int[] solution(int[] sequence, int k) {
        initSum(sequence);
        int[] answer = {0,1000000};
        
        int s=0, e=0;
        while(s<size && e<size){
            int sum = sumList.get(e)-sumList.get(s)+sequence[s];
            if(sum<k){
                e++;
            }
            else if(sum>k){
                s++;
            }
            else{
                if(answer[1]-answer[0]>e-s){
                    answer[1] = e;
                    answer[0] = s;
                }
                e++;
            }
        }
        return answer;
    }
    
    public void initSum(int[] sequence){
        sumList.add(sequence[0]);
        for(int i=1; i<sequence.length; i++){
            sumList.add(sumList.get(i-1)+sequence[i]);
        }
        size = sumList.size();
    }
}

// 1 3 6 10 15 // 2 3
// 15 - 10 + 4 = 9 -> 처음 계산이 k보다 크면 contiue
// 10 - 6 + 3 = 7 -> k와 같으면 continue
// 시작이 k보다 작으면 break
    
// 1 2 3 5 8 12 17 // 6 6
// 17 - 17 + 