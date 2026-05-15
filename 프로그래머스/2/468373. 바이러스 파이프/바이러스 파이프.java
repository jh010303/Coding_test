import java.util.*;

class Solution {
    
    List<List<List<Integer>>> graph = new ArrayList<>(); // graph
    List<Integer> infectedList = new ArrayList<>(); // 감염 리스트 저장
    int answer = 1;
    int n,k;
    
    public int solution(int n1, int infection, int[][] edges, int k1) {
        n = n1;
        k = k1;
        initGraph(edges);
        infectedList.add(infection);
        backTracking(0,1,0);
        return answer;
    }
    
    void backTracking(int cnt, int infected, int before){
        if(infected==n || cnt==k){ // 종료 조건 모두 감염되거나 행동을 다 사용했을 때
            answer = Math.max(answer,infected);
            return;
        }
        for(int i=1; i<=3; i++){ // A,B,C open
            if(i==before){ // 이전에 열었던 open 막음
                continue;
            }
            int infectCnt = infect(i);
            backTracking(cnt+1, infected+infectCnt, i);
            rollback(infectCnt);
        }
    }
    
    void rollback(int infectCnt){
        for(int i=0; i<infectCnt; i++){
            infectedList.remove(infectedList.size()-1);
        }
    }
    
    int infect(int type){
        Queue<Integer> infectedQ = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        for(int i=0; i<infectedList.size(); i++){
            infectedQ.add(infectedList.get(i));
            visited[infectedList.get(i)] = true;
        }
        
        int cnt = 0;
        while(!infectedQ.isEmpty()){
            int cur = infectedQ.poll();
            for(int i=0; i<graph.get(cur).get(type).size(); i++){
                int next = graph.get(cur).get(type).get(i);
                if(!visited[next]){
                    infectedQ.add(next);
                    visited[next]=true;
                    cnt++;
                    infectedList.add(next);
                }
            }
        }
        
        return cnt;
    }
    
    
    
    void initGraph(int[][] edges){
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
            for(int j=0; j<=3; j++){
                graph.get(i).add(new ArrayList<>());
            }
        }
        
        for(int i=0; i<edges.length; i++){
            int s = edges[i][0]; int e = edges[i][1]; int type = edges[i][2];
            graph.get(s).get(type).add(e);
            graph.get(e).get(type).add(s);
        }
    }
}