import java.util.*;

class Solution {
    class V{
        int n;
        int c;
        
        public V(int n, int c){
            this.n = n;
            this.c = c;
        }

    }
    
    PriorityQueue<V> pq = new PriorityQueue<>((a,b)->{
        return Integer.compare(a.c,b.c);
    });
    
    List<List<V>> graph = new ArrayList<>();
    int[] st;
        
    public int solution(int N, int[][] road, int K) {
        initGraph(N,road);
        int answer = 0;
        
        st = new int[N+1];
        Arrays.fill(st,Integer.MAX_VALUE);
        pq.clear();
        dijk();

        for(int i=1; i<st.length; i++){
            if(st[i]<=K){
                answer++;
            }
        }
        return answer;
    }
    
    void dijk(){
        pq.offer(new V(1, 0));
        st[1] = 0;
        
        while(!pq.isEmpty()){
            V cur = pq.poll();
            int cn = cur.n; int cc = cur.c;
            if(st[cn]<cc){
                continue;
            }
            for(int i=0; i<graph.get(cn).size(); i++){
                V next = graph.get(cn).get(i);
                int nn = next.n; int nc = cc+next.c;
                if(st[nn]<nc){
                    continue;
                }
                pq.offer(new V(nn,nc));
                st[nn] = nc;
            }
        }
        
    }
    
    void initGraph(int N, int[][] road){
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<road.length; i++){
            int s = road[i][0];
            int e = road[i][1];
            int c = road[i][2];
            graph.get(s).add(new V(e,c));
            graph.get(e).add(new V(s,c));
        }
    }
}