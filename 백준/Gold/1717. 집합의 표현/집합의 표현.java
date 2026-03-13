import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for(int i=0; i<=n; i++) {
			parent[i] = i;
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(cmd==0) {
				union(a,b);
			}
			else if(cmd==1) {
				if(find(a)==find(b)) {
					sb.append("YES").append("\n");
				}
				else {
					sb.append("NO").append("\n");
				}
			}
		}
		System.out.print(sb);
	}
	
	static void union(int a, int b) {
		int parentA = find(a); int parentB = find(b);
		if(parentA==parentB) return;
		parent[parentB] = parentA;
	}
	
	static int find(int n) {
		if(parent[n]==n) return n;
		parent[n] = find(parent[n]);
		return parent[n];
	}
}