import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> graph = new ArrayList<>();
	static int n,m,v;
	static Stack<Integer> stk = new Stack<>();
	static Queue<Integer> que = new LinkedList<>();
	static boolean[] dfs_visited = new boolean[1001];
	static boolean[] bfs_visited = new boolean[1001];
	
	
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		
		int temp1,temp2;
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			temp1 = Integer.parseInt(st.nextToken()); temp2 = Integer.parseInt(st.nextToken());
			graph.get(temp1).add(temp2); graph.get(temp2).add(temp1);
		}
		for(int i=0; i<=n; i++) {
			Collections.sort(graph.get(i), Collections.reverseOrder());
		}
		
		// dfs
		stk.push(v);
		while(!stk.empty()) {
			int top = stk.pop();
			if(!dfs_visited[top]) {
				dfs_visited[top] = true;
				System.out.print(top+" ");
			}
			for(Integer t:graph.get(top)) {
				if(!dfs_visited[t]) {
					stk.push(t);
				}
			}
		}
		
		System.out.println();
		for(int i=0; i<=n; i++) {
			Collections.sort(graph.get(i));
		}
		
		// bfs
		que.offer(v);
		bfs_visited[v] = true;
		while(!que.isEmpty()) {
			int top = que.poll();
			System.out.print(top+" ");
			for(Integer t:graph.get(top)) {
				if(!bfs_visited[t]) {
					bfs_visited[t]=true;
					que.offer(t);
				}
			}
		}
	}
}