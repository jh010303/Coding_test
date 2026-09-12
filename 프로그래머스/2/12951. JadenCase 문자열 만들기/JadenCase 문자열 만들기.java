import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c!=' '){
                temp.append(c);
            }
            else if(temp.length() > 0 && c==' '){
                StringBuilder sb = new StringBuilder(temp.toString().toLowerCase());
                sb.setCharAt(0,Character.toUpperCase(sb.charAt(0)));
                answer.append(sb).append(" ");
                temp.setLength(0);
            }
            else if(c==' '){
                answer.append(" ");
            }
        }
        if(temp.length() > 0){
            StringBuilder sb = new StringBuilder(temp.toString().toLowerCase());
            sb.setCharAt(0,Character.toUpperCase(sb.charAt(0)));
            answer.append(sb);
            temp.setLength(0);
        }
        return answer.toString();
    }
}

// "            "
// "             "