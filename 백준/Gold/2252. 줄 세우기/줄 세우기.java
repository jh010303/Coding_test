import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static List<List<Integer>> graph = new ArrayList<>();
	static Queue<Integer> que = new LinkedList<>();
	static int[] entry;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		entry = new int[n+1];
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph.get(s).add(e);
			entry[e]++;
		}
		

		for(int i=1; i<=n; i++) {
			if(entry[i]==0) {
				que.offer(i);
				sb.append(i).append(" ");
			}
		}
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			for(int i=0; i<graph.get(cur).size(); i++) {
				int next = graph.get(cur).get(i);
				entry[next]--;
				if(entry[next]<=0) {
					que.offer(next);
					sb.append(next).append(" ");
				}
			}
		}
		
		System.out.println(sb);
	}
}