import java.util.*;

class Solution {
    int answer = 0;
    public int solution(String name) {
        List<Integer> changeList = new ArrayList<>();
        for(int i=0; i<name.length(); i++){
            if(name.charAt(i)!='A'){
                changeList.add(i);
            }
        }
        int nameLen = name.length();
        int move = nameLen-1;
        for(int i=0; i<name.length(); i++){
            answer+=getChangeCnt(name.charAt(i));
            
            int next = i+1;
            while(next<nameLen && name.charAt(next)=='A'){
                next++;
            }
            
            move = Math.min(move,i*2+nameLen-next);
            move = Math.min(move,(nameLen-next)*2+i);
            
        }
        return answer+move;
    }
    
    int getChangeCnt(char target){
        return Math.min(target-'A', 91-target);
    }
}