import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0; int removeCnt = 0;
        
        while(!s.equals("1")){
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='0'){
                    removeCnt++;
                }
            }
            s = s.replace("0","");
            
            int siz = s.length();
            StringBuilder sb = new StringBuilder();
            while(siz>0){
                sb.append(siz%2);
                siz/=2;
            }
            s = sb.reverse().toString();
            cnt++;
        }
        answer[0] = cnt; answer[1] = removeCnt;
        return answer;
    }
}