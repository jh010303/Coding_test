import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        int[] secretCode = new int[5];
        combination(0,1,n,secretCode,q,ans);
        return answer;
    }
    
    void combination(int index, int next, int n, int[] secretCode, int[][] q, int[] ans){
        if(index>=5){
            boolean flag = true;
            for(int i=0; i<q.length; i++){
                if(compare(secretCode, q[i])!=ans[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer++;
            }
            return;
        }
        
        for(int i=next; i<=n; i++){
            secretCode[index] = i; 
            combination(index+1,i+1,n,secretCode,q,ans);
        }
        
    }
    
    int compare(int[] secretCode, int[] q){
        int res = 0;
        for(int i=0; i<secretCode.length; i++){
            for(int j=0; j<q.length; j++){
                if(secretCode[i]==q[j]){
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}