import java.util.*;

class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static Queue<Integer> que = new LinkedList<>();
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        init(n,wires);
        visited = new boolean[n+1];
        for(int i=0; i<n-1; i++){
            deleteNode(wires,i);
            
            Arrays.fill(visited,false);
            visited[1]=true;
            que.offer(1);
            
            int cnt=0;
            while(!que.isEmpty()){
                int cur = que.poll();
                for(int j=0; j<graph.get(cur).size(); j++){
                    int next = graph.get(cur).get(j);
                    if(!visited[next]){
                        que.offer(next);
                        visited[next]=true;
                    }
                }
                cnt++;
            }
            
            answer = Math.min(answer,Math.abs(n-cnt-cnt));
            addNode(wires,i);
        }
        return answer;
    }
    
    static void deleteNode(int[][] wires, int i){
        int start = wires[i][0];
        int end = wires[i][1];
        graph.get(start).remove(Integer.valueOf(end));
        graph.get(end).remove(Integer.valueOf(start));
    }
    
    static void addNode(int[][] wires, int i){
        int start = wires[i][0];
        int end = wires[i][1];
        graph.get(start).add(end);
        graph.get(end).add(start);
        
    }
    
    
    static void init(int n, int[][] wires){
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=1; i<=n-1; i++){
            int start = wires[i-1][0];
            int end = wires[i-1][1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
    }
}