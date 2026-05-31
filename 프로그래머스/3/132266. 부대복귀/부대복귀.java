import java.util.*;

class Solution {
    class Cord{
        int n;
        int cnt;
        public Cord(int n, int cnt){
            this.n = n;
            this.cnt = cnt;
        }
    }
    
    List<List<Integer>> graph = new ArrayList<>();
    Map<Integer,Integer> map = new HashMap<>();
    Queue<Cord> que = new LinkedList<>();
    boolean[] visited;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        Arrays.fill(answer,-1);
        initGraph(n,roads);
        initSource(sources);
        
        visited[destination] = true;
        que.offer(new Cord(destination,0));
        if(map.containsKey(destination)){
            answer[map.get(destination)] = 0;
        }
        
        while(!que.isEmpty()){
            Cord cur = que.poll();
            int curN = cur.n; int curCnt = cur.cnt;
            for(int i=0; i<graph.get(curN).size(); i++){
                int next = graph.get(curN).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    if(map.containsKey(next)){
                        answer[map.get(next)] = curCnt+1;
                    }
                    que.offer(new Cord(next,curCnt+1));
                }
            }
        }
        
        return answer;
    }
    
    void initSource(int[] sources){
        int index = 0;
        for(int i=0; i<sources.length; i++){
            int source = sources[i];
            if(!map.containsKey(source)){
                map.put(source,index++);
            }
        }
    }
    
    void initGraph(int n, int[][] roads){
        visited = new boolean[n+1];
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<roads.length; i++){
            int s = roads[i][0]; int e = roads[i][1];
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
    }
}