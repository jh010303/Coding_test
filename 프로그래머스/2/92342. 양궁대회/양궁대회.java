import java.util.*;

class Solution {
    int[] answer = new int[11];
    int diffMax = 1;
    public int[] solution(int n, int[] info) {
        int[] ryanList = new int[11];
        int[] empty = {-1};
        int apeach = 0;
        for(int i=0; i<info.length; i++){
            if(info[i]>0){
                apeach+=(10-i);
            }
        }
        recurSive(10,n,0,apeach,ryanList,info);
        if(diffMax==1){
            return empty;
        }
        return answer;
    }
    
    void recurSive(int depth, int n, int ryan, int apeach, int[] ryanList, int[] info){
        if(n<=0 || depth==-1){ // 쏠 화살이 없음
            if(depth==-1){
                ryanList[10]+=n;
            }
            int diff = ryan-apeach;
            if(diff>diffMax){
                for(int i=0; i<11; i++){
                    answer[i] = ryanList[i];
                }
                diffMax = diff;
            }
            if(depth==-1){
                ryanList[10]-=n;
            }
            //System.out.println(ryan+" "+apeach+" "+Arrays.toString(ryanList));
            return;
        }
        
        // 라이언이 맞추면서 이기는 선택
        if(info[depth]<n){
            ryanList[depth] = info[depth]+1;
            recurSive(depth-1,n-(info[depth]+1), ryan+10-depth, info[depth]>0?apeach-(10-depth):apeach, ryanList, info);
            ryanList[depth] = 0;
        }
        
        // 라이언이 맞추지 않는 선택 
        if(info[depth]==0){
            recurSive(depth-1,n,ryan,apeach,ryanList, info);
        }
        else{
            recurSive(depth-1,n,ryan,apeach, ryanList, info);
        }
        
    }
}

// 각 상태공간(획득할 점수)에서 상대보다 잘 쏠거냐, 포기할거냐 정할 수 있음
// 이길 수 있는데 지는 선택을 할 수도 있음
