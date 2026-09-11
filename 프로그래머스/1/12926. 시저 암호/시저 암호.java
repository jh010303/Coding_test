import java.util.*;

class Solution {
    char[] alphaList = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    HashMap<Character,Integer> alphaMap = new HashMap<>();

    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<alphaList.length; i++){
            alphaMap.put(Character.toLowerCase(alphaList[i]),i);
            alphaMap.put(Character.toUpperCase(alphaList[i]),i);
            
        }

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(alphaMap.containsKey(c)){
                int index = alphaMap.get(c);
                index = (index+n)%26;
                if(Character.isUpperCase(c)){
                    answer.append(Character.toUpperCase(alphaList[index]));
                }
                else{
                    answer.append(alphaList[index]);
                }
            }
            else{
                answer.append(c);
            }
        }
        return answer.toString();
    }
}
// 문자가 대문자인지, 소문자인지 판단하는 함수?
// 문자를 대문자, 소문자로 바꾸는 함수