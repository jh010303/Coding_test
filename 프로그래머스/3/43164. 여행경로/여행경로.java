import java.util.*;

class Solution {
    Map<String,Integer> mp = new HashMap<>();
    List<List<Integer>> ticketList = new ArrayList<>();
    List<List<String>> answer = new ArrayList<>();
    boolean[] visited;
    
    public List<String> solution(String[][] tickets) {
        initMap(tickets);
        initTicket(tickets);
        
        visited = new boolean[tickets.length];
        List<String> answerList = new ArrayList<>();
        
        
        answerList.add("ICN");
        dfs(tickets, answerList,mp.get("ICN"),0);
        
        Collections.sort(answer, (a,b)->{
            for(int i=0; i<a.size(); i++){
                String s1 = a.get(i);
                String s2 = b.get(i);
                
                if(!s1.equals(s2)){
                    return s1.compareTo(s2);
                }
            }
            
            return 0;
        });
        
        return answer.get(0);
    }
    
    void dfs(String[][] tickets, List<String> answerList, int cur, int depth){
        if(depth == tickets.length){
            List<String> temp = new ArrayList<>(answerList);
            answer.add(temp);
            
            return;
        }
        
        for(int i=0; i<ticketList.get(cur).size(); i++){
            int ticket = ticketList.get(cur).get(i);
            String nextS = tickets[ticket][1];
            int nextI = mp.get(nextS);
            if(!visited[ticket]){
                visited[ticket] = true;
                answerList.add(nextS);
                dfs(tickets,answerList,nextI,depth+1);
                answerList.remove(answerList.size()-1);
                visited[ticket] = false;
            }
        }
    }
    
    void initTicket(String[][] tickets){
        for(int i=0; i<mp.size(); i++){
            ticketList.add(new ArrayList<>());
        }
        for(int i=0; i<tickets.length; i++){
            String s = tickets[i][0];
            int index = mp.get(s);
            ticketList.get(index).add(i);
        }
    }
    
    void initMap(String[][] tickets){
        int index = 0;
        for(int i=0; i<tickets.length; i++){
            String s = tickets[i][0];
            String s1 = tickets[i][1];
            
            if(!mp.containsKey(s)){
                mp.put(s,index++);
            }
            if(!mp.containsKey(s1)){
                mp.put(s1,index++);
            }

        }
    }
}
        
// dfs 사용하기
