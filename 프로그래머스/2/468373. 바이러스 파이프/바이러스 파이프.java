import java.util.*;

class Solution {
    List<List<List<Integer>>> graph = new ArrayList<>();
    // 시작정점 -> 파이프 타입 -> 종료 정점들 담겨 있음
    boolean[] visited;
    int answer = 0;
    
    public int solution(int n, int infection, int[][] edges, int k){
        initGraph(n,edges);
        List<Integer> infections = new ArrayList<>();
        visited = new boolean[n+1];

        infections.add(infection);
        
        for(int pipe = 1; pipe<=3; pipe++){
            dfs(infections,pipe,0,k);
        }
        
        return answer;
    }
    
    int bfs(List<Integer> infections, int pipe){
        int cnt = 0;
        Queue<Integer> que = new LinkedList<>();
        Arrays.fill(visited,false);
        
        for(int i=0; i<infections.size(); i++){
            visited[infections.get(i)] = true;
        }
        
        int size = infections.size(); 
        
        for(int i=0; i<size; i++){
            que.offer(infections.get(i));
            
            while(!que.isEmpty()){
                int cur = que.poll();
                for(int j=0; j<graph.get(cur).get(pipe).size(); j++){
                    int next = graph.get(cur).get(pipe).get(j);
                    if(!visited[next]){
                        que.offer(next);
                        visited[next] = true;
                        infections.add(next);
                        cnt++;
                    }
                }
            }
        }
        
        return cnt;
        
    }
    
    void dfs(List<Integer> infections, int pipe, int depth, int k){
        if(depth==k){
            answer = Math.max(answer,infections.size());
            return;
        }
        
        int infectionCnt = bfs(infections,pipe);
        
        for(int p=1; p<=3; p++){
            dfs(infections,p,depth+1,k);
        }
        
        for(int i=0; i<infectionCnt; i++){
            infections.remove((int)infections.size()-1);
        }
        
    }
    
    void initGraph(int n, int[][] edges){
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
            for(int j=0; j<=3; j++){
                graph.get(i).add(new ArrayList<>());   
            }
        }
        
        for(int i=0; i<edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            int type = edges[i][2];
            
            graph.get(x).get(type).add(y);
            graph.get(y).get(type).add(x);
        }
    }
}

// 배양체: 정점
// 파이프: 간선 -> 간선 별 종류 있음
// 파이프를 열었다 닫는 행동 k번 반복 가능 -> 최대한 많은 배양체 감염 시키기

// infection은 늘어나기 때문에 list로 구현하기
