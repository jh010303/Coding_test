import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 1001;
        for(int size=1; size<=s.length()/2; size++){
            answer = Math.min(answer,compress(size,s));
        }
        if(s.length()==1){
            answer = 1;
        }
        return answer;
    }
    
    int compress(int size, String s){
        String bef = ""; String cur = "";
        int cnt = 0;
        int res = s.length();
        for(int i=0; i<s.length(); i+=size){  
            if(i+size>s.length()){
                cur = s.substring(i);
            }else{
                cur = s.substring(i,i+size);
            }

            if(cur.equals(bef)){
                cnt++;
            }
            else if(!cur.equals(bef) && cnt>0){
                res-=(cnt*size);
                res+=(String.valueOf(cnt+1).length());
                cnt = 0;
            }
            bef = cur;
        }
        if(cnt>0){
            res-=(cnt*size);
            res+=(String.valueOf(cnt+1).length());
        }
        return res;
    }
}

// 1로 압축하는 건 의미 없
// 2부터 문자열길이/2 만큼 진행

// < 압축 알고리즘 >
// 사이즈만큼 확인