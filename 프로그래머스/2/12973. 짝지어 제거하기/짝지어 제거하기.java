import java.util.*;

class Solution{
    public int solution(String s)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(sb.length()==0){
                sb.append(c);
            }
            else if(sb.charAt(sb.length()-1) == c){
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                sb.append(c);
            }
        }
        
        if(sb.length()==0){
            return 1;
        }
        return 0;
    }
}