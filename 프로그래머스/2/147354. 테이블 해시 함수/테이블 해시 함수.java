import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data,(a1,b1)->{
            if(a1[col-1]!=b1[col-1]){
                return a1[col-1]-b1[col-1];
            }
            else{
                return b1[0]-a1[0];
            }
        });

        for(int i=0; i<data[row_begin-1].length; i++){
            answer+=(data[row_begin-1][i]%row_begin);
        }
        
        for(int i=row_begin+1; i<=row_end; i++){
            int cur = 0;
            for(int j=0; j<data[i-1].length; j++){
                cur+=(data[i-1][j]%i);
            }
            answer^=cur;
        }
        return answer;
    }
}