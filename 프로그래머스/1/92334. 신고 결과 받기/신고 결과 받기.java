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
                    if(reportRelation[reportedIndex][j]>0){
                        answer[j]++;
                    }
                }
            }
        }
        
        // 유저 이름 : 인덱스 -> Map 
        // 유저가 몇 번 신고당했는지 -> int[] 횟수 담김
        // 해당 유저를 신고한 유저 목록 필요 -> int[][] -> 유저 인덱스

        // 유저별로 메일 받은 횟수 
        // 유저가 몇 번 신고당했는지 배열에서 값이 k이상인 인덱스 가져옴
        // 해당 유저를 신고한 유저 목록에서 그 인덱스의 인덱스에 값 추가
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