import java.util.*;
import java.io.*;

class Solution
{
    static class Vertex{
    	int n;
        int cnt;
        
        public Vertex(int n, int cnt){
        	this.n = n;
        	this.cnt = cnt;
        }
    }
    
    static List<List<Integer>> graph = new ArrayList<>();
    static Queue<Vertex> que = new LinkedList<>();
    
	public static void main(String args[]) throws Exception
	{
		StringBuilder sb = new StringBuilder();
       	StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            
            graph.clear();
            que.clear();
            
            for(int i=0; i<101; i++){
            	graph.add(new ArrayList<>());
            }
            
            st = new StringTokenizer(br.readLine());
            
            for(int i=0; i<n/2; i++){
            	int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph.get(s).add(e);
            }
            
            int answer = bfs(n,start);
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
        System.out.print(sb);
	}
    
    static int bfs(int n, int start){
        int maxCnt = 0; int maxN = 0;
    	boolean[] visited = new boolean[101];
        visited[start] = true;
        que.offer(new Vertex(start,0));
        
        while(!que.isEmpty()){
        	Vertex cur = que.poll();
            int cn = cur.n; int ccnt = cur.cnt;
            for(int i=0; i<graph.get(cn).size(); i++){
            	int nn = graph.get(cn).get(i); int ncnt = ccnt+1;
                if(!visited[nn]){
                	visited[nn] = true;
                    que.offer(new Vertex(nn,ncnt));
                    if(ncnt>maxCnt){
                        maxCnt = ncnt;
                        maxN = nn;
                    }
                    else if(ncnt==maxCnt){
                    	maxCnt = ncnt;
                        maxN = Math.max(nn,maxN);
                    }
                }
            }
        }
        
        return maxN;
    }
}