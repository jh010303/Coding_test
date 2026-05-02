import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        while(s.length()>0){
            char x = s.charAt(0);
            int xc = 0; int xnc = 0;
            boolean flag = false;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)==x){
                    xc++;
                }
                else{
                    xnc++;
                }
                if(xc==xnc){
                    answer++;
                    s = s.substring(i+1);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                answer++;
                break;
            }
        }
        return answer;
    }
}