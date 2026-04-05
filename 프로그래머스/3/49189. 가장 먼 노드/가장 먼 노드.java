import java.util.*;

class Solution {
    static class Cord{
        int n;
        int cnt;
        public Cord(int n, int cnt){
            this.n = n;
            this.cnt = cnt;
        }
    }
    static int[] distance;
    static boolean[] visited;
    static Queue<Cord> que = new LinkedList<>();
    static List<List<Integer>> graph = new ArrayList<>();
    static int maxV = -1;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        distance = new int[n+1];
        visited = new boolean[n+1];
        initGraph(n,edge);
        
        que.offer(new Cord(1,0));
        visited[1] = true;
        while(!que.isEmpty()){
            Cord cur = que.poll();
            int cn = cur.n; int ccnt = cur.cnt;
            for(int i=0; i<graph.get(cn).size(); i++){
                int nn = graph.get(cn).get(i); int ncnt = ccnt+1;
                if(!visited[nn]){
                    distance[nn] = ncnt;
                    visited[nn]=true;
                    maxV = Math.max(maxV,ncnt);
                    que.offer(new Cord(nn,ncnt));
                }
            }
        }
        
        for(int i=1; i<=n; i++){
            if(distance[i]==maxV){
                answer++;
            }
        }
        
        return answer;
    }
    
    static void initGraph(int n, int[][] edge){
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<edge.length; i++){
            int start = edge[i][0]; int end = edge[i][1];
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
    }
}