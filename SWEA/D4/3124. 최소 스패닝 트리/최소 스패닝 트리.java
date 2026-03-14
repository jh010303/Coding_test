import java.io.*;
import java.util.*;

public class Solution {
	static class Edge implements Comparable<Edge> {
		int s;
		int n;
		int w;

		public Edge(int s, int n, int w) {
			this.s = s;
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Edge e) {
			return this.w - e.w;
		}
	}

	static int v, e;
	static long ans;
	static Edge[] tree;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			tree = new Edge[e];
			parent = new int[v + 1];
			Arrays.fill(parent, -1);
			ans = 0;
			
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				tree[i] = new Edge(s, n, w);
			}

			Arrays.sort(tree);

			for (int i = 0; i < e; i++) {
				Edge cur = tree[i];
				int s = cur.s;
				int n = cur.n;
				int w = cur.w;
				if (find(s) != find(n)) {
					union(s, n);
					ans += w;
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}

		System.out.print(sb);
	}

	static int find(int n) {
		if (parent[n] < 0)
			return n;
		parent[n] = find(parent[n]);
		return parent[n];
	}

	static void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		if (parentA == parentB)
			return;
		else if (parentA < parentB) {
			parent[parentA] += parent[parentB];
			parent[parentB] = parentA;
		} else {
			parent[parentB] += parent[parentA];
			parent[parentA] = parentB;
		}
	}
}