import java.util.*;

class Solution {
    public List<Integer> solution(int n, int s) {
        List<Integer> answer = new ArrayList<>();
        if(s/n<1){
            answer.add(-1);
        }
        else{
            while(n>0){
                answer.add(s/n);
                s-=s/n;
                n--;
                
            }
        }
        return answer;
    }
}
