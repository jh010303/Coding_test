import java.util.*;

class Solution {
    int answer = 1251;
    int[][] exList = {{1,1,1},{5,1,1},{25,5,1}}; 
    public int solution(int[] picks, String[] minerals) {
        go(0,0,picks,minerals);
        return answer;
    }
    
    public void go(int start, int ex, int[] picks, String[] minerals){
        if(checkPicks(picks) || start>=minerals.length){
            answer = Math.min(answer,ex);    
        }
        
        for(int i=0; i<3; i++){
            if(picks[i]>0){
                picks[i]--;
                ex+=calculEx(i,start,minerals);
                go(start+5,ex,picks,minerals);
                picks[i]++;
                ex-=calculEx(i,start,minerals);
            }
        }
    }
    
    int calculEx(int pick, int start, String[] minerals){
        int ex = 0;
        for(int i=start; i<start+5; i++){
            if(i>=minerals.length){
                break;
            }
            int mineral = extractMineral(i,minerals);
            ex+=exList[pick][mineral];
        }
        return ex;
    }
    
    int extractMineral(int i, String[] minerals){
        if(minerals[i].equals("diamond")){
            return 0;
        }
        else if(minerals[i].equals("iron")){
            return 1;
        }
        return 2;
    }
    
    boolean checkPicks(int[] picks){
        for(int i=0; i<picks.length; i++){
            if(picks[i]>0){
                return false;
            }
        }
        return true;
    }
}