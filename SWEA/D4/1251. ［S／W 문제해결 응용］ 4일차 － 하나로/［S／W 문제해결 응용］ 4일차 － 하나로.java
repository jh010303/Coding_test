import java.io.*;
import java.util.*;

public class Solution {
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		long w;
		
		public Edge(int s, int e, long w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Long.compare(this.w, e.w);
		}
	}
	
	static class Node{
		int y;
		int x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int n;
	static Long ans;
	static double e;
	
	static int[] parent,yList,xList;
	static List<Edge> tree = new ArrayList<>();
	static Node[] nodes;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=t; test_case++) {
			n = Integer.parseInt(br.readLine());
			init();
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				int x = Integer.parseInt(st.nextToken());
				xList[i] = x;
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				int y = Integer.parseInt(st.nextToken());
				yList[i] = y;
			}
			e = Double.parseDouble(br.readLine());
			
			for(int i=1; i<=n; i++) {
				nodes[i] = new Node(yList[i],xList[i]);
			}
			
			for(int i=1; i<n; i++) {
				for(int j=i+1; j<=n; j++) {
					Node n1 = nodes[i]; Node n2 = nodes[j];
					Edge edge = new Edge(i,j,getDistance(n1, n2));
					tree.add(edge);
				}
			}
			Collections.sort(tree);
			
			
			for(int i=0; i<tree.size(); i++) {
				Edge edge = tree.get(i);
				int start = edge.s; int end = edge.e; long w =edge.w;
				if(find(start)!=find(end)) {
					union(start,end);
					ans+=w;
				}
			}
			
			ans = (long)(Math.round(ans*e));
			
			
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
	
	static int find(int n) {
		if(parent[n]<0) return n;
		parent[n] = find(parent[n]);
		return parent[n];
	}
	
	static void union(int a, int b) {
		int parentA = find(a); int parentB = find(b);
		if(parentA==parentB) return;
		else if(parent[parentA]<parent[parentB]) {
			parent[parentA]+=parent[parentB];
			parent[parentB]=parentA;
		}
		else {
			parent[parentB]+=parent[parentA];
			parent[parentA]=parentB;
		}
	}
	
	static long getDistance(Node n1, Node n2) {
		long dx = n1.x-n2.x;
		long dy = n1.y-n2.y;
		return dx*dx+dy*dy;
	}
	
	static void init() {
		parent = new int[n+1];
		yList = new int[n+1];
		xList = new int[n+1];
		nodes = new Node[n+1];
		tree.clear();
		Arrays.fill(parent, -1);
		ans = 0L;
	}
}