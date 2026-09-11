import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if('a'<= c && c<='z'){
                c = (char)('a'+(c-'a'+n)%26);
                
            }else if('A'<=c && c<='Z'){
                c = (char)('A'+(c-'A'+n)%26);
    
            }
            answer.append(c);
        }
        return answer.toString();
    }
}
// 문자가 대문자인지, 소문자인지 판단하는 함수?
// 문자를 대문자, 소문자로 바꾸는 함수