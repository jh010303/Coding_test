import java.util.*;

class Solution {
    HashMap<String,Integer> mp = new HashMap<>();
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int s1 = 0; int s2 = 9;
        
        // 크기10 윈도우 생성
        for(int i=0; i<10; i++){
            String s = discount[i];
            mp.put(s,mp.getOrDefault(s,0)+1);
        }
        
        while(true){
            // 윈도우 확인
            boolean flag = true;
            for(int i=0; i<want.length; i++){
                String s = want[i];
                int num = number[i];
                
                if(!mp.containsKey(s) || mp.get(s)!=num){
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer++;
            }
            
            // 윈도우 옮기기
            mp.put(discount[s1],mp.get(discount[s1])-1);
            
            s1++; s2++;
            if(s2>=discount.length){
                break;
            }
            
            mp.put(discount[s2],mp.getOrDefault(discount[s2],0)+1);
        }
        
        return answer;
    }
}