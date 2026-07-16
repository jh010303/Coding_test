import java.util.*;

class Solution {
    int[] answer = new int[11];
    int diff = 0;
    
    public int[] solution(int n, int[] info) {
        int[] falseResult = {-1};
        int[] result = new int[11];

        int apach = 0;
        for(int i=0; i<info.length; i++){
            if(info[i]>0){
                apach+=(10-i);
            }
        }
        
        backTracking(10,n,0,apach,result,n,info);
        
        boolean flag = false;
        for(int i=0; i<answer.length; i++){
            if(answer[i]!=0){
                flag = true;
                break;
            }
        }
        
        if(flag){
            return answer;
        }
        return falseResult;
    }
    
    void backTracking(int cnt, int left, int ryan, int apach, int[] result, int n, int[] info){
        if(cnt<0){ 
            if(ryan > apach && ryan-apach>=diff){
                for(int i=0; i<result.length; i++){
                    answer[i] = result[i];
                }
                if(left>0){
                    answer[10]+=left;
                }
                diff = ryan-apach;
            }
            return;
        }

        backTracking(cnt-1,left,ryan,apach,result,n,info);
        
        if(left>=info[cnt]+1){
            result[cnt] = info[cnt]+1;
            left-=result[cnt];
            ryan+=(10-cnt);
            if(info[cnt]>0){
                apach-=(10-cnt);
            }
            
            backTracking(cnt-1,left,ryan,apach,result,n,info);
            
            result[cnt] = 0;
        }
    }
}