import java.io.*;
import java.util.*;

public class Solution {
	static int n,m;
	static int[] parent;
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=t; test_case++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            parent = new int[n+1];
            set.clear();
            for(int i=1; i<=n; i++) {
                parent[i] = i;
            }
            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            }
            for(int i=1; i<=n; i++) {
                set.add(find(i));
            }
            
            sb.append("#").append(test_case).append(" ").append(set.size()).append("\n");
        }
		System.out.print(sb);
	}
	
	static void union(int a, int b) {
		int parentA = find(a); int parentB = find(b);
		if(parentA==parentB)return;
		parent[parentB]=parentA;
	}
	
	static int find(int n) {
		if(parent[n]==n)return n;
		parent[n] = find(parent[n]);
		return parent[n];
	}
}