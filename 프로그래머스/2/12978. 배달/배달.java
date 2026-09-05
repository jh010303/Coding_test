import java.util.*;

class Solution {
    class E implements Comparable<E>{
        int n;
        int w;
        
        public E(int n, int w){
            this.n = n;
            this.w = w;
        }
        
        @Override
        public int compareTo(E e){
            return Integer.compare(this.w,e.w);
        }
    }
    
    int[] st;
    List<List<E>> graph = new ArrayList<>();
    PriorityQueue<E> pq = new PriorityQueue<>();
        
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        st = new int[N+1];
        Arrays.fill(st,1000000001);
        
        initGraph(N,road);
        
        pq.offer(new E(1,0));
        
        while(!pq.isEmpty()){
            E cur = pq.poll();
            int cn = cur.n, cw = cur.w;
            
            if(st[cn]<cw){
                continue;
            }
            
            for(int i=0; i<graph.get(cn).size(); i++){
                E next = graph.get(cn).get(i);
                int nn = next.n, nw = next.w+cw;
                if(st[nn]<nw){
                    continue;
                }
                st[nn] = nw;
                pq.offer(new E(nn,nw));
            }
        }
        
        System.out.println(Arrays.toString(st));
        for(int i=2; i<st.length; i++){
            if(st[i]<=K){
                answer++;
            }
        }
        
        return answer+1;
    }
    
    void initGraph(int N, int[][] road){
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<road.length; i++){
            int s = road[i][0]; int e = road[i][1]; int w = road[i][2];
            graph.get(s).add(new E(e,w));
            graph.get(e).add(new E(s,w));
        }
    }
}