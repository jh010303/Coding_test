import java.util.*;
import java.io.*;

class Solution
{
	static int[] parent;
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parent = new int[n+1];
			Arrays.fill(parent, -1);
			int answer = 0;
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				union(n1,n2);
			}
			
			for(int i=1; i<parent.length; i++) {
				if(parent[i]<0) {
					answer++;
				}
			}
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static int find(int n) {
		if(parent[n]<0){
			return n;
		}
		return parent[n] = find(parent[n]);
	}
	
	static void union(int n1, int n2) {
		int p1 = find(n1), p2 = find(n2);
		if(p1==p2) {
			return;
		}
		parent[p1]+=parent[p2];
		parent[p2]=p1;
	}
}