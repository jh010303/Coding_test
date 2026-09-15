import java.util.*;

class Solution {
    HashMap<String,Integer> mp = new HashMap<>();    
    HashSet<String> st = new HashSet<>();
    
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        for(int i=0; i<gems.length; i++){
            st.add(gems[i]);
        }
        
        int p1=0; int p2=0; int mSize = 100001;
        mp.put(gems[p1],mp.getOrDefault(gems[p1],0)+1);
        
        while(p1<=p2){
            if(mSize==0){
                break;
            }
            
            boolean flag = true;
            if(st.size()!=mp.size()){
                flag = false;
            }
            
            if(!flag){ // 조건 만족 못하니 증가시켜야 함
                if(p2<gems.length-1){
                    p2++;
                    mp.put(gems[p2],mp.getOrDefault(gems[p2],0)+1);
                } 
                else{ // 증가 시키려고 하는데 마지막이면 더 볼필요 없음
                    break;
                }
            }
            else{ // 조건 만족 하니 감소시켜야 함
                if(p2-p1<mSize){
                    mSize = p2-p1;
                    answer[0] = p1+1; answer[1] = p2+1;
                }
                mp.put(gems[p1],mp.get(gems[p1])-1);
                if(mp.get(gems[p1])==0){
                    mp.remove(gems[p1]);
                }
                p1++;
            }
        }
        
        return answer;
    }
}

// map에 보석들 저장
// gems 배열돌면서 모든 보석들의 v가 1이상이 될 때 까지 p2 증가
// 만약 1이상이면 지금 윈도우 길이 정답 갱신하고 ( 작다면 ) p1 증가
// p2가 배열 길이 벗어나면 중지