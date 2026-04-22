import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = recursive(p);
        return answer;
    }
    
    String recursive(String p){
        if(p.length()==0){
            return "";
        }
        String u = ""; 
        String v = "";
        
        int cntL = 0; int cntR = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i)=='('){
                cntL++;
            }else if(p.charAt(i)==')'){
                cntR++;
            }
            if(cntL!=0 && cntL==cntR){
                u = p.substring(0,i+1);
                v = p.substring(i+1);
                break;
            }
        }
        
        if(checkPerfect(u)){
            return u+recursive(v);
        }
        else{
            return "(" + recursive(v) + ")" + reverse(u.substring(1,u.length()-1));
        }
    }

    String reverse(String str){
        String res = "";
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='('){
                res+=')';
            }
            else{
                res+='(';
            }
        }
        return res;
    }
    
    boolean checkPerfect(String p){
        Stack<Character> stk = new Stack<>();   
        
        for(int i=0; i<p.length(); i++){
            char next = p.charAt(i);
            if(stk.isEmpty()){
                stk.push(next);
                continue;
            }
            char top = stk.peek();
            if(top=='(' && next==')'){
                stk.pop();
            }
            else{
                stk.push(next);
            }
        }
        
        if(stk.isEmpty()){
            return true;
        }
        return false;
    }
}



