import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<sb.length(); i++){
            char c = sb.charAt(i);
            if(Character.isUpperCase(c)){
                c=(char)('A'+(c-'A'+n)%26);  
            }
            else if(Character.isLowerCase(c)){
                c=(char)('a'+(c-'a'+n)%26);    
            }
            sb.setCharAt(i,c);
        }
        return sb.toString();
    }
}