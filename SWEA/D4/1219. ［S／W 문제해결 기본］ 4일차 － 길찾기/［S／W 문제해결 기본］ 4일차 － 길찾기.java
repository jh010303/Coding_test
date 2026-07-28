import java.util.*;
import java.io.*;

class Solution
{
    static Queue<Integer> que = new LinkedList<>();
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int answer = 0;
			st = new StringTokenizer(br.readLine());
            st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            visited = new boolean[100];
            graph.clear();
            for(int i=0; i<100; i++){
            	graph.add(new ArrayList<>());
            }
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
            	int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph.get(s).add(e);
            }
            

            visited[0] = true;
            que.offer(0);
            
            while(!que.isEmpty()){
            	int cur = que.poll();
            	for(int i=0; i<graph.get(cur).size(); i++) {
            		int next = graph.get(cur).get(i);
                    if(next==99){
                    	answer = 1;
                        que.clear();
                        break;
                    }
                    if(visited[next]){
                    	continue;
                    }
    			
                    visited[next]=true;
                    que.offer(next);
            	}
            }
            
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
            
		}
        System.out.print(sb);
	}
}