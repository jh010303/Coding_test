import java.util.*;

class Solution {
    public String solution(String new_id) {
        
        new_id = new_id.toLowerCase();
        new_id = step2(new_id);
        new_id = step3(new_id);
        new_id = step4(new_id);
        if(new_id.length()==0){
            new_id+='a';
        }
        new_id = step6(new_id);
        new_id = step7(new_id);
        return new_id;
    }
    
    String step7(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.length()<=2){
            while(sb.length()!=3){
                sb.append(sb.charAt(sb.length()-1));
            }   
        }
        return sb.toString();
    }
    
    String step6(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.length()>=16){
            sb.delete(15,sb.length());
            if(sb.charAt(sb.length()-1)=='.'){
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }
    
    String step4(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.length()>0 && sb.charAt(sb.length()-1)=='.'){
            sb.deleteCharAt(sb.length()-1);
        }
        if(sb.length()>0 && sb.charAt(0)=='.'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
    
    String step3(String s){
        StringBuilder sb = new StringBuilder(s);
        int cont = 0;
        int start = 0;
        for(int i=0; i<sb.length(); i++){
            char c = sb.charAt(i);
            if(cont==0 && c=='.'){
                cont++;
                start = i;
            }
            else if(cont!=0 && c=='.'){
                cont++;
            }
            else if(cont<2 && c!='.'){
                cont=0;
            }
            else{
                if(cont>=2){
                    sb.delete(start,i-1);
                    cont = 0;
                    i = i-(i-1-start);
                }
            }
        }
        if(cont>=2){
            sb.delete(start,sb.length()-1);
        }
        return sb.toString();
    }
    
    String step2(String s){
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<sb.length(); i++){
            char c = sb.charAt(i);
            if(!(Character.isLetter(c) || c=='-' || c=='_' || c=='.' || ('0'<= c && c<='9'))){
                sb.deleteCharAt(i);
                i--;
            }
        }
        return sb.toString();
    }
}