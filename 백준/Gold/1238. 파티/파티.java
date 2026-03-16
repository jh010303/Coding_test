import java.util.*;
import java.io.*;

public class Main {
	static class Cord implements Comparable<Cord>{
		int n;
		int w;
		public Cord(int n, int w) {
			this.n = n;
			this.w = w;
		}
		@Override
		public int compareTo(Cord o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
	}
	
	static int n,m,x,ans=-1;
	static List<List<Cord>> graph = new ArrayList<List<Cord>>();
	static PriorityQueue<Cord> que = new PriorityQueue<>();
	static int[] path;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		path = new int[n+1];
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Cord>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			graph.get(s).add(new Cord(e,t));
		}
		
		// 각 지점에서 x까지 최단거리
		for(int i=1; i<=n; i++) {
			if(i==x)continue;
			que.offer(new Cord(i,0));
			int[] dp = new int[n+1];
			Arrays.fill(dp, 1000001);
			while(!que.isEmpty()) {
				Cord cur = que.poll();
				int curN = cur.n; int curW = cur.w;
				if(curW>dp[curN])continue;
				for(int j=0; j<graph.get(curN).size(); j++) {
					Cord next = graph.get(curN).get(j);
					int nextN = next.n; int nextW = next.w+curW;
					if(nextW>dp[nextN]) {
						continue;
					}
					que.offer(new Cord(nextN,nextW));
					dp[nextN]=nextW;
				}
			}
			path[i]+=dp[x];
		}
		
		// x에서 각 지점까지 최단거리
		for(int i=1; i<=n; i++) {
			if(i==x)continue;
			que.offer(new Cord(x,0));
			int[] dp = new int[n+1];
			Arrays.fill(dp, 1000001);
			while(!que.isEmpty()) {
				Cord cur = que.poll();
				int curN = cur.n; int curW = cur.w;
				if(curW>dp[curN])continue;
				for(int j=0; j<graph.get(curN).size(); j++) {
					Cord next = graph.get(curN).get(j);
					int nextN = next.n; int nextW = next.w+curW;
					if(nextW>dp[nextN]) {
						continue;
					}
					que.offer(new Cord(nextN,nextW));
					dp[nextN]=nextW;
				}
			}
			path[i]+=dp[i];
		}
		
		for(int i=1; i<=n; i++) {
			if(ans<path[i]) {
				ans = path[i];
			}
		}
		System.out.print(ans);
	}
}