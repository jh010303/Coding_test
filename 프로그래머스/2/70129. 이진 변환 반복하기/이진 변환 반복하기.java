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
            
            StringBuilder sb = new StringBuilder();
            int n = s.length();
            while(n>0){
                sb.append(n%2);
                n/=2;
            }
            s = sb.reverse().toString();
            cnt++;
        }
        
        answer[0] = cnt; answer[1] = removeCnt;
        return answer;
    }
}