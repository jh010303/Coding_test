import java.util.*;

class Solution {
    HashMap<String,Integer> userIdMap = new HashMap<>();
    
    int[] reportCnt;
    int[][] reportRelation;
    
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        reportCnt = new int[id_list.length];
        reportRelation = new int[id_list.length][id_list.length];
        initMap(id_list);
        
        for(int i=0; i<report.length; i++){
            StringTokenizer st = new StringTokenizer(report[i]);
            String user = st.nextToken();
            String reported = st.nextToken();
            int userIndex = userIdMap.get(user);
            int reportedIndex = userIdMap.get(reported);
            
            if(reportRelation[reportedIndex][userIndex]==0){
                reportCnt[reportedIndex]++;
                reportRelation[reportedIndex][userIndex]++;
            }
        }
        
        for(int i=0; i<reportCnt.length; i++){
            int reportedIndex = i;
            if(reportCnt[reportedIndex]>=k){
                for(int j=0; j<reportRelation[reportedIndex].length; j++){
                    int user = j;
                    if(reportRelation[reportedIndex][user]>0){
                        answer[user]++;
                    }
                }
            }
        }
        return answer;
    }
    
    void initMap(String[] id_list){
        int index = 0;
        for(int i=0; i<id_list.length; i++){
            String name = id_list[i];
            if(!userIdMap.containsKey(name)){
                userIdMap.put(name,index++);
            }
        }
    }
}