import java.util.*;

class Solution {
    HashMap<Long, Long> mp = new HashMap<>(); // 요청한 방 번호, 
    
    public List<Long> solution(long k, long[] room_number) {
        List<Long> answer = new ArrayList<>();
        
        for(int i=0; i<room_number.length; i++){
            answer.add(find(room_number[i]));    
        }
        
        return answer;
    }
    
    long find(long n){ // 넣을 방 번호 줘야 함
        if(!mp.containsKey(n)){ // 빈 방일 때
            mp.put(n,n+1);
            return n; 
        }
        // 방이 이미 존재할 때
        long next = find(mp.get(n)); // 다음에 줄 방 번호
        mp.put(n,next);
        return next; 
    }
}

