import java.io.*;
import java.util.*;

public class Solution {
	static int n,m;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=t; test_case++){
            sb.append("#").append(test_case).append(" ");
            st = new StringTokenizer(br.readLine());
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
                        sb.append("1");
                    }
                    else {
                        sb.append("0");
                    }
                }
            }
            sb.append("\n");
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