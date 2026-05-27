import java.util.*;

class Solution {
    
    Set<List<Integer>> st = new HashSet<>();
    List<Integer> stopId = new ArrayList<>();
    boolean[] visited;
    
    public int solution(String[] user_id, String[] banned_id) {
        System.out.println(same("crodo","*rodo"));
        visited = new boolean[user_id.length];
        backTracking(user_id, banned_id,0);
        return st.size();
    }
    
    List<Integer> copyArray(List<Integer> temp, List<Integer> stopId){
        for(int i=0; i<stopId.size(); i++){
            temp.add(stopId.get(i));
        }
        return temp;
    }
    
    void backTracking(String[] userId, String[] bannedId, int index){
        if(index>=bannedId.length){ // stopId가 bannedId만큼 채워졌을 때
            List<Integer> temp = new ArrayList<>();
            copyArray(temp,stopId);
            Collections.sort(temp);
            st.add(temp);
            return;
        }
        
        for(int i=0; i<userId.length; i++){
            if(same(userId[i],bannedId[index]) && !visited[i]){
                visited[i] = true;
                stopId.add(i);
                backTracking(userId,bannedId,index+1); 
                stopId.remove(stopId.size()-1);
                visited[i] = false;
            }
        }
    }
    
    boolean same(String user, String ban){
        if(ban.length()!=user.length()){
            return false;
        }
        for(int i=0; i<user.length(); i++){
            char u = user.charAt(i); char b = ban.charAt(i);
            if(u==b || b=='*'){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}