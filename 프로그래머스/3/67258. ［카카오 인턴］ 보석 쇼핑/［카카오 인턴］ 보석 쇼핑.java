import java.util.*;

class Solution {
    HashMap<String,Integer> gemindex = new HashMap<>();
    int[] visited;
    int minL = Integer.MAX_VALUE;
    public int[] solution(String[] gems) {
        initGemIndex(gems);
        int[] answer = new int[2];
        visited = new int[gemindex.size()];
        int l=0; int r=0;
        while(true){
            if(checkVisited()){
                String gem = gems[l++];
                visited[gemindex.get(gem)]--;
                if(r-l<minL){
                    minL = r-l;
                    answer[0] = l;
                    answer[1] = r;
                }
            }
            else{
                if(r>=gems.length){
                    break;
                }
                String gem = gems[r++];
                visited[gemindex.get(gem)]++;
            } 
        }
        return answer;
    }
    
    boolean checkVisited(){
        for(int i=0; i<visited.length; i++){
            if(visited[i]<=0){
                return false;
            }
        }
        return true;
    }
    
    void initGemIndex(String[] gems){
        int index = 0;
        for(int i=0; i<gems.length; i++){
            String gem = gems[i];
            if(!gemindex.containsKey(gem)){
                gemindex.put(gem,index++);
            }
        }
    }
}