import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int size = arr.length;
        quadDiv(arr,0,0,size);
        countE(answer, arr,size);
        return answer;
    }
    
    public void quadDiv(int[][] arr, int startY, int startX, int size){
        if(size==1){
            return;
        }
        
        int temp = arr[startY][startX];
        boolean quad = true;
        for(int i=startY; i<startY+size; i++){
            for(int j=startX; j<startX+size; j++){
                if(arr[i][j]!=temp){
                    quad = false;
                    break;
                }
            }
        }
        
        if(quad){
            zip(arr,startY,startX,size);
        }
        else{
            size/=2;
            quadDiv(arr,startY,startX,size);
            quadDiv(arr,startY+size,startX,size);
            quadDiv(arr,startY,startX+size,size);
            quadDiv(arr,startY+size,startX+size,size);
        }
    }
    
    public void zip(int[][] arr, int startY, int startX, int size){
        int temp = arr[startY][startX];
        for(int i=startY; i<startY+size; i++){
            for(int j=startX; j<startX+size; j++){
                arr[i][j] = -1;
            }
        }
        arr[startY][startX]=temp;
    }
    
    public void countE(int[] answer, int[][] arr, int size){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(arr[i][j]==0){
                    answer[0]++;
                }
                else if(arr[i][j]==1){
                    answer[1]++;
                }
            }
        }
    }
}