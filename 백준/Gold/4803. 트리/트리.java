import java.io.*;
import java.util.*;

public class Main {
	static int n,m,cnt;
	static int[] parent;
	static boolean[] cycle;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int test_case = 1;
		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			init();
			if(n==0 && m==0) {
				break;
			}
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			
			countTree();
			printAnswer(test_case++);
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
		if(parentA==parentB && parentA>0) { // cycle 존재
			cycle[parentA] = true;
		}
		else if(parent[parentA] <= parent[parentB]) { // A가 더 큼
			parent[parentA]+=parent[parentB];
			parent[parentB]=parentA;
		}else { // B가 더 큼
			parent[parentB]+=parent[parentA];
			parent[parentA]=parentB;
		}
	}
	
	static void countTree() {
		for(int i=1; i<=n; i++) {
			if(parent[i]<0 && !cycle[i]) {
				cnt++;
			}
		}
	}
	
	static void init() {
		parent = new int[n+1];
		cycle = new boolean[n+1];
		cnt = 0;
		Arrays.fill(parent, -1);
	}
	
	static void printAnswer(int test_case) {
		sb.append("Case ").append(test_case).append(": ");
		if(cnt==0) {
			sb.append("No trees.").append("\n");
		}
		else if(cnt==1) {
			sb.append("There is one tree.").append("\n");
		}
		else {
			sb.append("A forest of ").append(cnt).append(" trees.").append("\n");
		}
	}
}