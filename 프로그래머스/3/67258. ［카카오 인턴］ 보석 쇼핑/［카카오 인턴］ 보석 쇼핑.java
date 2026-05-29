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
            //System.out.println("함수 실행");
            if(checkVisited()){
                String gem = gems[l++];
                visited[gemindex.get(gem)]--;
                if(r-l<minL){
                    minL = r-l;
                    answer[0] = l;
                    answer[1] = r;
                    //System.out.println("답 갱신");
                }
                //System.out.println("l증가");
            }
            else{
                if(r>=gems.length){
                    break;
                }
                String gem = gems[r++];
                visited[gemindex.get(gem)]++;
                //System.out.println("r증가");
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