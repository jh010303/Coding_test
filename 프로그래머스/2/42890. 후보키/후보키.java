import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        int col = relation[0].length;
        int row = relation.length;
        List<Integer> candList = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        
        for(int cand=1; cand<(1<<col); cand++){
            boolean flag = false;
            hs.clear();
            
            for(int j=0; j<candList.size(); j++){ // 최소성을 만족하는지?
                int c = candList.get(j);
                if((c&cand)==c){
                    flag = true;
                    break;
                }
            }
            
            if(!flag){
                for(int j=0; j<row; j++){
                    String temp = "";
                    for(int r=0; r<col; r++){
                        if((cand&(1<<r))!=0){
                            temp+=relation[j][r];
                        }
                    }
                    hs.add(temp);
                }
            }
            
            if(hs.size()==row){
                candList.add(cand);
                answer++;
            }
        }
        return answer;
    }
}
