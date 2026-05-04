import java.util.*;

class Solution {
    int[][] arr;
    public int solution(int n, int w, int num) {
        arr = new int[(int)Math.ceil((double)n/w)][w];
        fillArr(n);
        int answer = find(num);
        return answer;
    }
    
    int find(int num){
        int cnt = 0;
        for(int i=0; i<arr[0].length; i++){
            cnt = 0;
            for(int j=0; j<arr.length; j++){
                if(arr[j][i]!=0){
                    cnt++;
                }
                if(arr[j][i]==num){
                    return cnt;
                }
            }
        }
        return cnt;
    }
    
    void fillArr(int n){
        boolean flag = true;
        int fill = 1;
        for(int i=arr.length-1; i>=0; i--){
            if(flag){ // 오른쪽
                for(int j=0; j<arr[i].length; j++){
                    arr[i][j] = fill++;
                    if(fill>n){
                        return;
                    }
                }
                flag = false;
            }
            else{ // 왼쪽
                for(int j=arr[i].length-1; j>=0; j--){
                    arr[i][j] = fill++;
                    if(fill>n){
                        return;
                    }
                }
                flag = true;
            }
            
        }
    }
}

// n/w의 올림만큼 높이 필요