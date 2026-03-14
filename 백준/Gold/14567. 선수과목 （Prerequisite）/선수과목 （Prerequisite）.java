import java.io.*;
import java.util.*;

public class Main {
	static class Cord{
		int n;
		int w;
		public Cord(int n, int w) {
			this.n = n;
			this.w = w;
		}
	}
	static int n,m;
	static int[] entry,ans;
	static List<List<Integer>> graph = new ArrayList<>();
	static Queue<Cord> que = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		entry = new int[n+1];
		ans = new int[n+1];
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			entry[b]++;
		}
		
		for(int i=1; i<=n; i++) {
			if(entry[i]==0) {
				que.offer(new Cord(i,1));
				ans[i]=1;
			}
		}
		
		while(!que.isEmpty()) {
			Cord cur = que.poll();
			int curN = cur.n; int curW = cur.w;
			for(int i=0; i<graph.get(curN).size(); i++) {
				int next = graph.get(curN).get(i);
				entry[next]--;
				if(entry[next]==0) {
					que.offer(new Cord(next,curW+1));
					ans[next]=curW+1;
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			sb.append(ans[i]+" ");
		}
		System.out.print(sb);
	}
}